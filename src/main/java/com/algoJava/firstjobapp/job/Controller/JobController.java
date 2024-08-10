package com.algoJava.firstjobapp.job.Controller;

import com.algoJava.firstjobapp.job.Entity.Job;
import com.algoJava.firstjobapp.job.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/job")
    public List<Job> getAllJob(){

        return jobService.getAllJob();
    }

    @GetMapping("/job/{id}")
    public Optional<Job> getJobById(@PathVariable int id){
        return jobService.getJobById(id);
    }

    @PostMapping("/job")
    public String saveJobs(@RequestBody Job job){
        jobService.saveJob(job);
        return "Job added successfully";
    }

    @PutMapping("/job/{id}")
    public Optional<Job> updateJobById(@PathVariable int id, @RequestBody Job job){
        return jobService.updateJob(id,job);
    }

    @DeleteMapping("/job/{id}")
    public String deleteById(@PathVariable int id) {
        jobService.deleteJob(id);
        return "Job deleted Successfully";
    }
}
