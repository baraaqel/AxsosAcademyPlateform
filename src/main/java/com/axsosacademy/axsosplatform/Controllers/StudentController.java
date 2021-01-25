package com.axsosacademy.axsosplatform.controllers;

import com.axsosacademy.axsosplatform.models.Algorithm;
import com.axsosacademy.axsosplatform.models.Category;
import com.axsosacademy.axsosplatform.models.GroupActivity;
import com.axsosacademy.axsosplatform.models.Topic;
import com.axsosacademy.axsosplatform.services.AlgorithmService;
import com.axsosacademy.axsosplatform.services.CategoryService;
import com.axsosacademy.axsosplatform.services.GroupActivityService;
import com.axsosacademy.axsosplatform.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    private final AlgorithmService algorithmService;
    private final TopicService topicService;
    private final CategoryService categoryService;
    private final GroupActivityService groupActivityService;

    public StudentController(AlgorithmService algorithmService, TopicService topicService, CategoryService categoryService, GroupActivityService groupActivityService) {
        this.algorithmService = algorithmService;
        this.topicService = topicService;
        this.categoryService = categoryService;
        this.groupActivityService = groupActivityService;
    }
    //Get topics for Algorithm Student Page
    @GetMapping("/student/algorithms/showTopics")
    public String showTopics(@ModelAttribute("algorithm") Algorithm algorithm, Model model, HttpSession session) {
        List<Topic> allTopics = topicService.findAllTopics();
        model.addAttribute("allTopics",allTopics);
        return "/topicsPageStudent.jsp";
    }

    //Get categories for Group Activity Student Page
    @GetMapping("/student/groupActivity/showCategories")
    public String showCategories(@ModelAttribute("groupActivity") GroupActivity groupActivity, Model model, HttpSession session) {
        List<Category> allCategories = categoryService.findAllCategories();
        model.addAttribute("allCategories",allCategories);
        return "/categoriesStudentPage.jsp";
    }
}
