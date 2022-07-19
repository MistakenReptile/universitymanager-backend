package com.example.universitymanager.repo;

import com.example.universitymanager.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniversityRepo extends JpaRepository<University,Long> {
    void deleteUniversityById(Long id);

    Optional<University> findUniversityById(Long id);


}
