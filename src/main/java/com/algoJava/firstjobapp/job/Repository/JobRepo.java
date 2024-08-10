package com.algoJava.firstjobapp.job.Repository;

import com.algoJava.firstjobapp.job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepo extends JpaRepository<Job, Integer> {
}
