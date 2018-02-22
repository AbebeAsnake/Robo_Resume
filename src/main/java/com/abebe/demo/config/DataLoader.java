package com.abebe.demo.config;

import com.abebe.demo.model.DesiredSkills;
import com.abebe.demo.model.Jobs;
import com.abebe.demo.model.Role;
import com.abebe.demo.model.User;
import com.abebe.demo.repo.DesiredSkillsRepository;
import com.abebe.demo.repo.JobsRepository;
import com.abebe.demo.repo.DesiredSkillsRepository;
import com.abebe.demo.repo.RoleRepository;
import com.abebe.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    DesiredSkillsRepository desiredSkillsRepository;
    @Override
    public void run(String...strings) throws Exception{
        System.out.println("Loading data ....");
        roleRepository.save(new Role("APPLICANT"));
        roleRepository.save(new Role("EMPLOYER"));
        roleRepository.save(new Role("RECURITER"));
        Role employerRole = roleRepository.findByRole("EMPLOYER");
        Role applicantRole = roleRepository.findByRole("APPLICANT");
        Role recuriterRole = roleRepository.findByRole("RECURITER");

        User user = new
                User("employer@employer.com","password","employer","emp", true,"employer");
        user.setRoles(Arrays.asList(employerRole));
        userRepository.save(user);
              user = new
                      User("applicant@applicant.com","password","applicant","app", true,"applicant");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);
        user = new
                User("recuriter@recuriter.com","password","recuriter","recu", true,"recuriter");
        user.setRoles(Arrays.asList(recuriterRole));
        userRepository.save(user);
       /* Jobs job = new Jobs("developer","java developer for contract to hire ");
          jobsRepository.save(job);*/

        Jobs jobs=  new Jobs("developer","xx", "org2");

            jobsRepository.save(jobs);

    }
}