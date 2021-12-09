package com.vansisto.students.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int student_id;
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
