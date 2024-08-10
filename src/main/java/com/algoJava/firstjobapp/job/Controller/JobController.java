package com.algoJava.firstjobapp.job.Controller;

import com.algoJava.firstjobapp.job.Entity.Job;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    private List<Job> jobList = new ArrayList<>();

    @GetMapping("/job")
    public List<Job> getAllJob(){
        return jobList;
    }

    @GetMapping("/job/{id}")
    public Optional<Job> getJobById(@PathVariable Long id){
        for (int i = 0; i< jobList.size(); i++){
            if (jobList.get(i).getId() == id){
                return Optional.ofNullable(jobList.get(i));
            }
        }
        return null;
    }

    @PostMapping("/job")
    public String saveJobs(@RequestBody Job job){
        jobList.add(job);
        return "Job added successfully";
    }
}
