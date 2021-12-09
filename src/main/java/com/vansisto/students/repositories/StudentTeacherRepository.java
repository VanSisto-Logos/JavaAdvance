package com.vansisto.students.repositories;

import com.vansisto.students.dao.StudentTeacher;

import java.util.List;

public interface StudentTeacherRepository {
    void create(StudentTeacher studentTeacher);
    void update(StudentTeacher studentTeacher);
    void delete(StudentTeacher studentTeacher);
    StudentTeacher getById(int id);
    List<StudentTeacher> getAll();
}
