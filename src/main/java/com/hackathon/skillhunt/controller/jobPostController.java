package com.hackathon.skillhunt.controller;

import com.hackathon.skillhunt.dto.CreateJobPostDTO;
import com.hackathon.skillhunt.entity.JobPostEntity;
import com.hackathon.skillhunt.entity.SkillsMaster;
import com.hackathon.skillhunt.repository.JobPostRepository;
import com.hackathon.skillhunt.repository.SkillsMasterRepository;
import com.hackathon.skillhunt.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jobPost")
public class jobPostController {

    @Autowired
    private JobPostService jobPostService;

    @PostMapping("/createJobPost")
    @PreAuthorize("hasAuthority('admin')")
    public String createJobPost(@RequestBody CreateJobPostDTO createJobPostDTO){
        String response = null;
        response = jobPostService.createJobPost(createJobPostDTO);
        return response;
    }

    @GetMapping("/getJobPosts")
    //@PreAuthorize("hasAuthority('admin')")
    public  List<CreateJobPostDTO> getJobPosts(){
        return jobPostService.getAllJobPost();
    }

    @GetMapping("/getSkills")
    public List<SkillsMaster> getSkills(){
       return jobPostService.getSkills();
    }


}
