package com.vansisto.students.controllers;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.services.StudentServiceImpl;

import java.util.List;

public class StudentController {
    private StudentServiceImpl service = new StudentServiceImpl();
    public List<Student> getAllByTeacher(Teacher teacher){
        return service.getAllByTeacherId(teacher.getTeacher_id());
    }
}
