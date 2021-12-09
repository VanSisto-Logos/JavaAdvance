package com.vansisto.students.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentTeacher {
    private int students_teachers_id;
    private int student_id;
    private int teacher_id;

    public StudentTeacher(int student_id, int teacher_id) {
        this.student_id = student_id;
        this.teacher_id = teacher_id;
    }
}
