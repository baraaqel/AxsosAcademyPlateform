package com.axsosacademy.axsosplatform.services;


import com.axsosacademy.axsosplatform.models.User;
import com.axsosacademy.axsosplatform.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



}
