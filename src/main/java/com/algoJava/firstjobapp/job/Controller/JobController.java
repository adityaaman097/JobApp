package com.algoJava.firstjobapp.job.Controller;

import com.algoJava.firstjobapp.job.Entity.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJobById(@PathVariable int id, @RequestBody Job job){
        Optional<Job> existingJobOpt = jobList.stream().filter(j-> j.getId() == id).findFirst();

        if (existingJobOpt.isPresent()){
                Job existingJob = existingJobOpt.get();
                existingJob.setTitle(job.getTitle());
                existingJob.setDesc(job.getDesc());
                existingJob.setLocation(job.getLocation());
                existingJob.setMinSalary(job.getMinSalary());
                existingJob.setMaxSalary(job.getMaxSalary());
                return new ResponseEntity<>(existingJob, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<Optional<Job>> deleteById(@PathVariable int id) {
        Optional<Job> existingJobOpt = jobList.stream().filter(j -> j.getId() == id).findFirst();

        if (existingJobOpt.isPresent()){
                jobList.remove(existingJobOpt.get());
                return new ResponseEntity<>(existingJobOpt, HttpStatus.NO_CONTENT);
            }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
