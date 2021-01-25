package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.GroupActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupActivityRepository extends CrudRepository<GroupActivity, Long> {
    public List<GroupActivity> findAll();
}
