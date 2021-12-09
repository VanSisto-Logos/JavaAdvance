package com.vansisto.students.repositories;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.Teacher;

import java.util.List;

public interface TeacherRepository {
    void createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    List<Teacher> getAllTeacher();
}
