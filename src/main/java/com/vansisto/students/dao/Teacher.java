package com.vansisto.students.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private int teacher_id;
    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
