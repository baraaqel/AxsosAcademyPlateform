package com.axsosacademy.axsosplatform.services;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.Topic;
import com.axsosacademy.axsosplatform.models.User;
import com.axsosacademy.axsosplatform.repositories.AlgorithmRepository;
import com.axsosacademy.axsosplatform.repositories.TopicRepository;
import com.axsosacademy.axsosplatform.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private TopicRepository topicRepository;
    private UserRepository userRepository;
    private AlgorithmRepository algorithmRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, AlgorithmRepository algorithmRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.algorithmRepository = algorithmRepository;
    }

    //    save Algo.
    public Algorithm save(Algorithm algorithm) {

        return algorithmRepository.save(algorithm);
    }
//    creat topic
    public Topic create(Topic topic) {

        return topicRepository.save(topic);
    }
//    return all topics
    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }

//    find a specific topic
    public Topic findOneById(Long id) {
        Optional<Topic> optionalTopic= topicRepository.findById(id);

        if(optionalTopic.isPresent()) {
            return optionalTopic.get();
        } else {
            return null;
        }
    }

// get all students
    public List<User> findAllStudents(){
        return userRepository.findUsersByRole("student");
    }
// delete Topic
    public void deleteTopic(Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()) {
            // CascadeType.REMOVE in Show.java will also delete the reviews associated with that show.
            topicRepository.deleteById(id);
        } else {
            System.out.println("Show does not exist");
        }
    }

    public void deleteCategory(Long id){
        topicRepository.deleteById(id);
    }


}
