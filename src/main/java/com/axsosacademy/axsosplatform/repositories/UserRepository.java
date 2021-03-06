package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
    List<User> findUsersByRole(String type);
}
