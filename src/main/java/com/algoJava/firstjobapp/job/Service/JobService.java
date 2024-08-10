package com.algoJava.firstjobapp.job.Service;

import com.algoJava.firstjobapp.job.Entity.Job;
import com.algoJava.firstjobapp.job.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public List<Job> getAllJob(){
        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(int id){
        return jobRepo.findById(id);
    }

    public Job saveJob(Job job){
        return jobRepo.save(job);
    }

        public Optional<Job> updateJob(int id, Job job){
             Optional<Job> existingJobOpt = jobRepo.findById(id);
            if (existingJobOpt.isPresent()) {
                Job existingJob = existingJobOpt.get();
                existingJob.setTitle(job.getTitle());
                existingJob.setDesc(job.getDesc());
                existingJob.setLocation(job.getLocation());
                existingJob.setMinSalary(job.getMinSalary());
                existingJob.setMaxSalary(job.getMaxSalary());
                jobRepo.save(existingJob);
            }
            return existingJobOpt;
        }

    public void deleteJob(int id){
       jobRepo.deleteById(id);
    }
}
