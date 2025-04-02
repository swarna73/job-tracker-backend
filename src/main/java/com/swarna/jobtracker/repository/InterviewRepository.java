package com.swarna.jobtracker.repository;

import com.swarna.jobtracker.entity.Interview;
import com.swarna.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByApplication(JobApplication application);
}