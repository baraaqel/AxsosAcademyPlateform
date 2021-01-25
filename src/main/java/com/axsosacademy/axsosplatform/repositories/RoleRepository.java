package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.Role;
import com.axsosacademy.axsosplatform.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

}
