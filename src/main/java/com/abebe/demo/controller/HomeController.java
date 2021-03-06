package com.abebe.demo.controller;

import com.abebe.demo.model.*;
import com.abebe.demo.repo.*;
import com.abebe.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

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
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    DesiredSkillsRepository desiredSkillsRepository;
private long x;

    @RequestMapping("/")
    public String addResume(Model model){

        return "index";
    }
    @RequestMapping("/displayresume")
    public String DiplayResume(Model model){
        model.addAttribute("person",personRepository.findAll());
        model.addAttribute("skills",skillsRepository.findAll());
        model.addAttribute("education", educationRepository.findAll());
        model.addAttribute("workexprience", workExperienceRepository.findAll());
        model.addAttribute("reference", referencesRepository.findAll());
        model.addAttribute("summary", summaryRepository.findAll());

        return "displayperson";
    }

    @GetMapping("/postp")
    public  String postProcess(Model model){
        model.addAttribute("person",new Applicant());
        model.addAttribute("personforms",personRepository.findAll());
        return "personform";
    }
    @PostMapping("/postp")
    public  String processForm(@Valid @ModelAttribute Applicant person, BindingResult result){
        if(result.hasErrors()){
            return "personform";
        }
        personRepository.save(person);
        return "redirect:/displayresume";
    }
    @GetMapping("/poste")
    public  String postProcesseduForm(Model model){
        model.addAttribute("education",new Education());
        model.addAttribute("educationform", educationRepository.findAll());
        return "educationform";
    }

    @PostMapping("/poste")
    public  String processEdu(@Valid @ModelAttribute Education education, BindingResult result){
        if(result.hasErrors()){
            return "educationform";
        }
        educationRepository.save(education);
        return "redirect:/displayresume";
    }
    @GetMapping("/postw")
    public  String postProcesseWeForm(Model model){
        model.addAttribute("workexperience",new WorkExperience());
        model.addAttribute("workexprience", workExperienceRepository.findAll());
        return "workexperienceform";
    }

    @PostMapping("/postw")
    public  String processWorkExperience(@Valid @ModelAttribute WorkExperience workexperience, BindingResult result, Model model){
        if(result.hasErrors()){
            return "workexperienceform";
        }
        workExperienceRepository.save(workexperience);

        return "redirect:/displayresume";
    }
    @GetMapping("/posts")
    public  String postProcesseSkills(Model model){
        model.addAttribute("skills",new Skills());
        model.addAttribute("skillsform", skillsRepository.findAll());

        return "skillsform";
    }

    @PostMapping("/posts")
    public  String processSkills(@Valid @ModelAttribute Skills skills, BindingResult result){
        if(result.hasErrors()){
            return "skillsform";
        }
        skillsRepository.save(skills);
        return "redirect:/displayresume";
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
        model.addAttribute("referenceform", referencesRepository.findAll());



        return "references";
    }

    @PostMapping("/refernce")
    public  String processRefernces(@Valid @ModelAttribute References references, BindingResult result){
        if(result.hasErrors()){
            return "references";
        }
        referencesRepository.save(references);
        return "redirect:/displayresume";
    }

    @GetMapping("/summary")
    public  String postSummery(Model model){
        model.addAttribute("summarys", new Summarys());
        model.addAttribute("summaryform", summaryRepository.findAll());

        return "summary";
    }

    @PostMapping("/summary")
    public  String processSummery(@Valid @ModelAttribute Summarys summary, BindingResult result){
        if(result.hasErrors()){
            return "summary";
        }
        summaryRepository.save(summary);
        return "redirect:/displayresume";
    }
    @GetMapping("/coverletter")
    public  String postCoverLetter(Model model){
        model.addAttribute("cover", new CoverLetter());
        return "coverletter";
    }

    @PostMapping("/coverletter")
    public  String processSummery(@Valid @ModelAttribute CoverLetter coverLetter, BindingResult result){
        if(result.hasErrors()){
            return "coverletter";
        }
        coverLetterRepository.save(coverLetter);
        return "redirect:/displayresume";
    }


    @RequestMapping("/register")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

        model.addAttribute("user", user);

        if(result.hasErrors()){
            return "registration";
        }

        userService.saveUser(user);
        model.addAttribute("message", "User account successfully created");

        return "redirect:/displayresume";

    }
    @RequestMapping("update/{id}")
    public String updatePersonInfo(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findOne(id));
        return "personform";
    }
    @RequestMapping("/delete/{id}")
    public String delPersonInfo(@PathVariable("id") long id){
        personRepository.delete(id);
        return "redirect:/displayresume";
    }

    @RequestMapping("updateE/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepository.findOne(id));
        return "educationform";
    }
    @RequestMapping("/deleteE/{id}")
    public String deleteEducation(@PathVariable("id") long id){
        educationRepository.delete(id);
        return "redirect:/displayresume";
    }

    @RequestMapping("updateS/{id}")
    public String updateSkills(@PathVariable("id") long id, Model model){
        model.addAttribute("skills", skillsRepository.findOne(id));
        return "skillsform";
    }
    @RequestMapping("/deleteS/{id}")
    public String deleteSkills(@PathVariable("id") long id){
        skillsRepository.delete(id);
        return "redirect:/displayresume";
    }

    @RequestMapping("updateR/{id}")
    public String updateReference(@PathVariable("id") long id, Model model){
        model.addAttribute("reference", referencesRepository.findOne(id));
        return "references";
    }
    @RequestMapping("/deleteR/{id}")
    public String deleteReference(@PathVariable("id") long id){
        referencesRepository.delete(id);
        return "redirect:/displayresume";
    }

    @RequestMapping("updateWE/{id}")
    public String updateWorkExperience(@PathVariable("id") long id, Model model){
        model.addAttribute("workexperience", workExperienceRepository.findOne(id));
        return "workexperienceform";
    }
    @RequestMapping("/deleteWE/{id}")
    public String deleteWorkExperience(@PathVariable("id") long id){
        workExperienceRepository.delete(id);
        return "redirect:/displayresume";
    }
    @GetMapping("/addjob")
    public  String addJobForm(Model model){
        model.addAttribute("job", new Jobs());
        return "addjob";
    }

    @PostMapping("/addjob")
    public  String addJob( Jobs jobs, BindingResult result){
        if(result.hasErrors()){
            return "addjob";
        }
        jobsRepository.save(jobs);
        return "redirect:/";
    }

    @RequestMapping("/addqualification")
    public  String lisJobs(Model model, Jobs job){
        model.addAttribute("job", jobsRepository.findAll());
        x =job.getId();
        return "listjobs";
    }
   @GetMapping("/desired")
    public String addQualification(Model model){
        model.addAttribute("desired", new DesiredSkills());

        return "adddesiredskills";
   }

    @PostMapping("/desiredskills")
    public String desiredskill(HttpServletRequest request, Model model)
    {
        model.addAttribute("list",jobsRepository.findOne(new Long(request.getParameter("id"))));

        return "adddesiredskills";
    }
    @RequestMapping("/desiredskills")
    public String adddesired(DesiredSkills desired,BindingResult result){
        if(result.hasErrors()){
            return "adddesiredskills";
        }
        desiredSkillsRepository.save(desired);
        return "redirect:/";
    }

}
