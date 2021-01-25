package com.axsosacademy.axsosplatform.services;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.Category;
import com.axsosacademy.axsosplatform.models.GroupActivity;
import com.axsosacademy.axsosplatform.repositories.CategoryRepository;
import com.axsosacademy.axsosplatform.repositories.GroupActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupActivityService {
    private final GroupActivityRepository groupActivityRepository;

    public GroupActivityService(GroupActivityRepository groupActivityRepository) {
        this.groupActivityRepository = groupActivityRepository;
    }

    public GroupActivity createGroupActivity(Category category, GroupActivity groupActivity){
        category.getGroupActivities().add(groupActivity);
        return groupActivityRepository.save(groupActivity);
    }

    public GroupActivity findOneById(Long id) {
        Optional<GroupActivity> optionalGroupActivity= groupActivityRepository.findById(id);

        if(optionalGroupActivity.isPresent()) {
            return optionalGroupActivity.get();
        } else {
            return null;
        }
    }

    public void deleteGroupActivity(Long id){
        groupActivityRepository.deleteById(id);
    }

}
