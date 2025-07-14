package com.fiddich.LectureMapping;

import com.fiddich.LectureMapping.helper.SchoolMapper;
import com.fiddich.LectureMapping.service.CategoryService;
import com.fiddich.LectureMapping.service.LectureService;
import com.fiddich.LectureMapping.service.SchoolService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 메인 클래스

@Component
@RequiredArgsConstructor
public class LectureDataInitializer {
    private final CategoryService categoryService;
    private final LectureService lectureService;
    private final SchoolService schoolService;

    @PersistenceContext
    private final EntityManager em;



    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() throws Exception {
        // 강의를 가져올 학년도
        String year = "2025";
        String semester = "1";

        List<Long> schoolIds = new ArrayList<>();
        schoolIds.add(13L);

        // 학교 정보 설정
        for(Long schoolId : schoolIds) {
            String schoolName = SchoolMapper.getNameById(schoolId);
            schoolService.initializeSchool(schoolId, schoolName);
        }

        em.flush();
        em.clear();


        // 카테고리 정보 수집 및 저장
        categoryService.fetchAndSaveCategories(year, semester);

        em.flush();
        em.clear();

        // 강의 정보 수집 및 저장
        lectureService.fetchAndSaveAllLectures(year, semester, 50);
    }
}
