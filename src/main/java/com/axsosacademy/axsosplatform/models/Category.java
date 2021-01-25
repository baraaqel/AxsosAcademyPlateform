package com.axsosacademy.axsosplatform.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<GroupActivity> groupActivities;

    public Category() {

    }

    public Category(String name, List<GroupActivity> groupActivities) {
        this.name = name;
        this.groupActivities = groupActivities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<GroupActivity> getGroupActivities() {
        return groupActivities;
    }

    public void setGroupActivities(List<GroupActivity> groupActivities) {
        this.groupActivities = groupActivities;
    }
}
