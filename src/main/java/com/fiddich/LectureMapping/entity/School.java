package com.fiddich.LectureMapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class School {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long id;

    private String name;
    private String code;

//    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
//    private List<Department> departments = new ArrayList<>();
}
