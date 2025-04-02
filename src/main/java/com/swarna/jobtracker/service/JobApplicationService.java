package com.swarna.jobtracker.service;

import com.swarna.jobtracker.entity.JobApplication;
import com.swarna.jobtracker.entity.User;
import com.swarna.jobtracker.repository.JobApplicationRepository;
import com.swarna.jobtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;
    
    public JobApplication createApplication(JobApplication app) {
    	
        if (app.getUser() != null && app.getUser().getId() != null) {
            User existingUser = userRepository.findById(app.getUser().getId())
                                              .orElseThrow(() -> new RuntimeException("User not found"));
            app.setUser(existingUser); // hydrate with managed entity
        } else {
            throw new RuntimeException("User ID is required");
        }
        return applicationRepository.save(app);
    }

    public JobApplication saveApplication(JobApplication application) {
        return applicationRepository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    public List<JobApplication> getApplicationsByUser(Long userId) {
        return userRepository.findById(userId)
                .map(applicationRepository::findByUser)
                .orElse(List.of());
    }

    public List<JobApplication> getByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}