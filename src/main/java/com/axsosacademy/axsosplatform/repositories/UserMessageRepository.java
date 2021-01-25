package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.Topic;
import com.axsosacademy.axsosplatform.models.User;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMessageRepository extends CrudRepository<User, Long> {

}
