package com.axsosacademy.axsosplatform.repositories;

import com.axsosacademy.axsosplatform.models.Algorithm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmRepository extends CrudRepository<Algorithm, Long> {
    public List<Algorithm> findAll();
    public void deleteAlgorithmById(Long id);


}
