package com.fiddich.LectureMapping.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private Long member_id;

    private String code;
    private String codeSection;
    private String name;
    private String professor;
    private String type;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureTime> lectureTimes = new ArrayList<>();

    private String place;
    private String credit;
    private String target;
    private String notice;


    public void addLectureTime(LectureTime lectureTime) {
        this.lectureTimes.add(lectureTime);
        lectureTime.setLecture(this);
    }
}
