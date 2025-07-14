package com.fiddich.LectureMapping.service;

import com.fiddich.LectureMapping.entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {
    @PersistenceContext
    private final EntityManager em;

    private School school;

    public void initializeSchool(Long campusId, String campusName) {

        School existingSchool = em.find(School.class, campusId);

        if (existingSchool != null) {
            this.school = existingSchool;
        } else {
            School school = new School();
            school.setId(campusId);
            school.setName(campusName);
            em.persist(school);
            this.school = school;
        }
    }

    public School getCurrentSchool() {
        return this.school;
    }
}
