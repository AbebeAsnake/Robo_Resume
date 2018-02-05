package com.abebe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    WorkExperienceRepository workExperienceRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @RequestMapping("")
    public String addResume(Model model){
        model.addAttribute("person",personRepository.findAll());
        model.addAttribute("skills",skillsRepository.findAll());
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("workexprience", workExperienceRepository.findAll());
        return "displayperson";
    }

    @GetMapping("/postp")
    public  String postProcess(Model model){
        model.addAttribute("person",new Person());
        return "personform";
    }
    @PostMapping("/postp")
    public  String processForm(@Valid @ModelAttribute Person person, BindingResult result){
        if(result.hasErrors()){
            return "personform";
        }
        personRepository.save(person);
        return "redirect:/";
    }
    @GetMapping("/poste")
    public  String postProcesseduForm(Model model){
        model.addAttribute("education",new Education());
        return "educationform";
    }

    @PostMapping("/poste")
    public  String processEdu(@Valid @ModelAttribute Education education, BindingResult result){
        if(result.hasErrors()){
            return "educationform";
        }
        educationRepository.save(education);
        return "redirect:/";
    }
    @GetMapping("/postw")
    public  String postProcesseWeForm(Model model){
        model.addAttribute("workexperience",new WorkExperience());
        return "workexperienceform";
    }

    @PostMapping("/postw")
    public  String processWorkExperience(@Valid @ModelAttribute WorkExperience workexperience, BindingResult result){
        if(result.hasErrors()){
            return "workexperienceform";
        }
        workExperienceRepository.save(workexperience);
        return "redirect:/";
    }
    @GetMapping("/posts")
    public  String postProcesseSkills(Model model){
        model.addAttribute("skills",new Skills());
        return "skillsform";
    }

    @PostMapping("/posts")
    public  String processSkills(@Valid @ModelAttribute Skills skills, BindingResult result){
        if(result.hasErrors()){
            return "skillsform";
        }
        skillsRepository.save(skills);
        return "redirect:/";
    }


}
