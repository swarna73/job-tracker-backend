package com.swarna.jobtracker.service;

import com.swarna.jobtracker.entity.Interview;
import com.swarna.jobtracker.entity.JobApplication;
import com.swarna.jobtracker.repository.InterviewRepository;
import com.swarna.jobtracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JobApplicationRepository applicationRepository;

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public List<Interview> getInterviewsByApplication(Long appId) {
        return applicationRepository.findById(appId)
                .map(interviewRepository::findByApplication)
                .orElse(List.of());
    }

    public Optional<Interview> getInterviewById(Long id) {
        return interviewRepository.findById(id);
    }

    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}