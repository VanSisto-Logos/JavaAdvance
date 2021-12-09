package com.vansisto.students.repositories;

import com.vansisto.students.dao.Student;

import java.util.List;

public interface StudentRepository {
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
