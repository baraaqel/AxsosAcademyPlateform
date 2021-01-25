package com.axsosacademy.axsosplatform.services;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.Topic;
import com.axsosacademy.axsosplatform.repositories.AlgorithmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public AlgorithmService(AlgorithmRepository algorithmRepository) {
        this.algorithmRepository = algorithmRepository;
    }

    public List<Algorithm> getAllAlgorithms(){
        return algorithmRepository.findAll();
    }

    public Algorithm createAlgorithm(Topic topic, Algorithm algorithm){
        topic.getAlgorithms().add(algorithm);
        return algorithmRepository.save(algorithm);
    }

    public void deleteAlgorithm(Long id){
        algorithmRepository.deleteById(id);
    }


}
