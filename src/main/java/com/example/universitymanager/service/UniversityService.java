package com.example.universitymanager.service;

import com.example.universitymanager.exception.UserNotFoundException;
import com.example.universitymanager.model.University;
import com.example.universitymanager.repo.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityService {
    private final UniversityRepo universityRepo;

    @Autowired
    public UniversityService(UniversityRepo universityRepo) {
        this.universityRepo = universityRepo;
    }

    public University addUniversity(University university) {
        university.setUniversityCode(UUID.randomUUID().toString());
        return universityRepo.save(university);
    }

    public List<University> findAllUniversities(){
        return universityRepo.findAll();
    }

    public University updateUniversity(University university){
        return universityRepo.save(university);
    }

    public University findUniversityById(Long id){
        return universityRepo.findUniversityById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }

    public void deleteUniversity(Long id){
        universityRepo.deleteUniversityById(id);
    }
}
