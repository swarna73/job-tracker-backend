package com.swarna.jobtracker.repository;

import com.swarna.jobtracker.entity.JobApplication;
import com.swarna.jobtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByUser(User user);
    List<JobApplication> findByStatus(String status);
}