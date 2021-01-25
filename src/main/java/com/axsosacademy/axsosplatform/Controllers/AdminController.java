package com.axsosacademy.axsosplatform.controllers;

import com.axsosacademy.axsosplatform.models.*;
import com.axsosacademy.axsosplatform.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    private final AlgorithmService algorithmService;
    private final TopicService topicService;
    private final CategoryService categoryService;
    private final GroupActivityService groupActivityService;
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(AlgorithmService algorithmService, TopicService topicService, CategoryService categoryService, GroupActivityService groupActivityService, UserService userService, RoleService roleService) {
        this.algorithmService = algorithmService;
        this.topicService = topicService;
        this.categoryService = categoryService;
        this.groupActivityService = groupActivityService;
        this.userService = userService;
        this.roleService = roleService;
    }

    public Long userSessionId(HttpSession session) {
        if(session.getAttribute("userId") == null)
            return null;
        return (Long)session.getAttribute("userId");
    }

    //***********************************************************************************************
    //Admin Algorithm Process

    //Check Role
    @GetMapping("/algorithmsProcess")
    public String checkRoleForAlgorithm(@ModelAttribute("algorithm") Algorithm algorithm, Model model, HttpSession session) {
        Long userId = this.userSessionId(session);
        User user = this.userService.findUser(userId);
        if(user.isAdmin()){
            return "redirect:/admin/algorithms/showTopics";
        }
        return "redirect:/student/algorithms/showTopics";
    }
    //Get topics for Algorithm Admin Page
    @GetMapping("/admin/algorithms/showTopics")
    public String showTopics(@ModelAttribute("algorithm") Algorithm algorithm, Model model, HttpSession session) {
        List<Topic> allTopics = topicService.findAllTopics();
        model.addAttribute("allTopics",allTopics);
        return "/topicsPageAdmin.jsp";
    }

    //Create a new algorithm
    @PostMapping("/algorithms/new")
    public String createAlgorithm(@Valid @ModelAttribute("algorithm") Algorithm algorithm, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        this.algorithmService.createAlgorithm(algorithm.getTopic(),algorithm);
        return "redirect:/admin/algorithms/showTopics";
    }

    // Add a Topic inside topics dropdown
    @GetMapping("/addTopic")
    public String addTopic(@Valid @ModelAttribute("topic") Topic topic, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        return "addTopic.jsp";
    }

    @PostMapping("/addTopic")
    public String createTopic(@Valid @ModelAttribute("topic") Topic topic, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        this.topicService.create(topic);
        return "redirect:/admin/algorithms/showTopics";
    }

    //Get algorithm for a specific topic Admin Page
    @GetMapping("/algorithms/{topicId}")
    public String showAlgorithms(@ModelAttribute("algorithm") Algorithm algorithm,@PathVariable("topicId") Long id, Model model, HttpSession session) {
        Topic selectedTopic = topicService.findOneById(id);
        List<Algorithm> topicAlgorithms = selectedTopic.getAlgorithms();
        model.addAttribute("topicAlgorithms",topicAlgorithms);
        model.addAttribute("selectedTopic",selectedTopic);
        return "/algorithmsPageAdmin.jsp";
    }

    //delete algorithm
    @GetMapping("/algorithms/{topicId}/{algorithmId}/delete")
    public String deleteAlgorithms(@ModelAttribute("algorithm") Algorithm algorithm,@PathVariable("algorithmId") Long id,@PathVariable("topicId") Long topicId, Model model, HttpSession session) {
    algorithmService.deleteAlgorithm(id);
        return "redirect:/algorithms/{topicId}";
    }

    //delete topic
    @GetMapping("/algorithms/{topicId}/delete")
    public String deleteTopic(@ModelAttribute("algorithm") Algorithm algorithm,@PathVariable("topicId") Long topicId, Model model, HttpSession session) {
        topicService.deleteTopic(topicId);
        return "redirect:/algorithmsProcess";
    }
    //***********************************************************************************************
    //Admin Group Activity Process

    //Check Role
    @GetMapping("/groupActivitiesProcess")
    public String checkRoleForGroupActivity(@ModelAttribute("groupActivity") GroupActivity groupActivity, Model model, HttpSession session) {
        Long userId = this.userSessionId(session);
        User user = this.userService.findUser(userId);
        if(user.isAdmin()){
            return "redirect:/admin/groupActivity/showCategories";
        }
        return "redirect:/student/groupActivity/showCategories";
    }

    //Get categories for Group Activity Admin Page
    @GetMapping("/admin/groupActivity/showCategories")
    public String showCategories(@ModelAttribute("groupActivity") GroupActivity groupActivity, Model model, HttpSession session) {
        List<Category> allCategories = categoryService.findAllCategories();
        model.addAttribute("allCategories",allCategories);
        return "/categoriesAdminPage.jsp";
    }

    // Add a Category inside categories dropdown
    @GetMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        return "addCategory.jsp";
    }

    @PostMapping("/addCategory")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        this.categoryService.create(category);
        return "redirect:/admin/groupActivity/showCategories";
    }

    //Create a new group activity
    @PostMapping("/groupActivity/new")
    public String createGroupActivity(@Valid @ModelAttribute("groupActivity") GroupActivity groupActivity, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        this.groupActivityService.createGroupActivity(groupActivity.getCategory(),groupActivity);
        return "redirect:/admin/groupActivity/showCategories";
    }

    //Get group activity for a specific category Admin Page
    @GetMapping("/groupActivities/{categoryId}")
    public String showGroupActivities(@ModelAttribute("groupActivity") GroupActivity groupActivity,@PathVariable("categoryId") Long id, Model model, HttpSession session) {
        Category selectedCategory = categoryService.findOneById(id);
        List<GroupActivity> categoryGroupActivities = selectedCategory.getGroupActivities();
        model.addAttribute("categoryGroupActivities",categoryGroupActivities);
        model.addAttribute("selectedCategory",selectedCategory);
        return "/groupActivitiesAdminPage.jsp";
    }

    //Get group activity for a specific category Admin Page
    @RequestMapping("/groupActivity/{groupActivityId}")
    public String showSelectedGroupActivity(@ModelAttribute("groupActivity") GroupActivity groupActivity,@PathVariable("groupActivityId") Long id, Model model, HttpSession session) {
        GroupActivity selectedGroupActivity = groupActivityService.findOneById(id);
        model.addAttribute("selectedGroupActivity",selectedGroupActivity);
        return "singleGroupActivity.jsp";
    }

    //delete group activity
    @GetMapping("/groupActivities/{categoryId}/{groupActivityId}/delete")
    public String deleteGroupActivity(@ModelAttribute("GroupActivity") GroupActivity groupActivity,@PathVariable("groupActivityId") Long id,@PathVariable("categoryId") Long categoryId, Model model, HttpSession session) {
        groupActivityService.deleteGroupActivity(id);
        return "redirect:/groupActivities/{categoryId}";
    }

    //delete category
    @GetMapping("/groupActivities/{categoryId}/delete")
    public String deleteCategory(@ModelAttribute("groupActivity") GroupActivity groupActivity,@PathVariable("categoryId") Long categoryId, Model model, HttpSession session) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/groupActivitiesProcess";
    }


}
