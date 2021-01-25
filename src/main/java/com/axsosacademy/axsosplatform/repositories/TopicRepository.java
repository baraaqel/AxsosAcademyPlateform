package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAll();

}
