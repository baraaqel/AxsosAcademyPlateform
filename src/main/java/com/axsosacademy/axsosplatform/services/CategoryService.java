package com.axsosacademy.axsosplatform.services;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.Category;
import com.axsosacademy.axsosplatform.models.Topic;
import com.axsosacademy.axsosplatform.repositories.AlgorithmRepository;
import com.axsosacademy.axsosplatform.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category create(Category category) {

        return categoryRepository.save(category);
    }

    //    find a specific category
    public Category findOneById(Long id) {
        Optional<Category> optionalCategory= categoryRepository.findById(id);

        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
