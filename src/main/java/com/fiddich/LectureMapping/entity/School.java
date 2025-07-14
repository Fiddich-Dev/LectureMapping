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
    @Column(name = "school_id")
    private Long id;

    private String name;

}
