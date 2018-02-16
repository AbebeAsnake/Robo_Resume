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
    ReferencesRepository referencesRepository;
    @Autowired
    UserService userService;
    @Autowired
    ApplicantRepository personRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    WorkExperienceRepository workExperienceRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    SummaryRepository summaryRepository;
    @Autowired
    CoverLetterRepository coverLetterRepository;
    @RequestMapping("/")
    public String addResume(Model model){
        model.addAttribute("person",personRepository.findAll());
        model.addAttribute("skills",skillsRepository.findAll());
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("workexprience", workExperienceRepository.findAll());
        return "displayperson";
    }

    @GetMapping("/postp")
    public  String postProcess(Model model){
        model.addAttribute("person",new Applicant());
        return "personform";
    }
    @PostMapping("/postp")
    public  String processForm(@Valid @ModelAttribute Applicant person, BindingResult result){
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
    @GetMapping("/register")
    public String showRegistration(Model model){
        model.addAttribute("registration", new User());
        return "registration";

    }

    @RequestMapping("/login")
    public String showLogin(Model model){
        return "login";
    }
    @GetMapping("/refernce")
    public  String postReference(Model model){
        model.addAttribute("reference",new References());
        return "references";
    }

    @PostMapping("/refernce")
    public  String processRefernces(@Valid @ModelAttribute References references, BindingResult result){
        if(result.hasErrors()){
            return "references";
        }
        referencesRepository.save(references);
        return "redirect:/";
    }

    @GetMapping("/summary")
    public  String postSummery(Model model){
        model.addAttribute("summarys", new Summarys());
        return "summary";
    }

    @PostMapping("/summary")
    public  String processSummery(Summarys summary, BindingResult result){
        if(result.hasErrors()){
            return "summary";
        }
        summaryRepository.save(summary);
        return "redirect:/";
    }
    @GetMapping("/coverletter")
    public  String postCoverLetter(Model model){
        model.addAttribute("cover", new CoverLetter());
        return "coverletter";
    }

    @PostMapping("/coverletter")
    public  String processSummery(CoverLetter coverLetter, BindingResult result){
        if(result.hasErrors()){
            return "coverletter";
        }
        coverLetterRepository.save(coverLetter);
        return "redirect:/";
    }

}
