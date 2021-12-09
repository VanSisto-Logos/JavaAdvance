package com.vansisto.students.services;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.StudentTeacher;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.repositories.StudentTeacherRepository;
import com.vansisto.students.repositories.impl.StudentTeacherRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
    private StudentServiceImpl studentService = new StudentServiceImpl();
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();
    private StudentTeacherRepository studentTeacherRepository = new StudentTeacherRepositoryImpl();
    private List<Student> students;

    @BeforeEach
    void init(){
        students = new ArrayList<>();

        students.add(new Student(4, "Lambda"));
        students.add(new Student(5, "Charlie"));
        students.add(new Student(6, "Chuck"));

        studentService.create(students.get(0));
        studentService.create(students.get(1));
        studentService.create(students.get(2));

        teacherService.create(new Teacher(3, "Teacher"));

        studentTeacherRepository.create(new StudentTeacher(1, 4, 3));
        studentTeacherRepository.create(new StudentTeacher(2, 5, 3));
        studentTeacherRepository.create(new StudentTeacher(3, 6, 3));
    }

    @Test
    void getAllByTeacherId() {
        assertIterableEquals(students, studentService.getAllByTeacherId(3));
    }

    @AfterEach
    void tearDown() {
        studentTeacherRepository.delete(new StudentTeacher(1,1,1));
        studentTeacherRepository.delete(new StudentTeacher(2,1,1));
        studentTeacherRepository.delete(new StudentTeacher(3,1,1));
        studentService.delete(students.get(0));
        studentService.delete(students.get(1));
        studentService.delete(students.get(2));
        teacherService.delete(new Teacher(3, ""));
    }
}