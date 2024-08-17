package org.example.jobboardspringboot.job;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    public Job getJobById(Long id);
    public List<Job> findAll();
    public boolean deleteJobById(Long id);
}
