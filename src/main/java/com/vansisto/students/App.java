package com.vansisto.students;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.StudentTeacher;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.repositories.StudentRepository;
import com.vansisto.students.repositories.StudentTeacherRepository;
import com.vansisto.students.repositories.TeacherRepository;
import com.vansisto.students.repositories.impl.StudentTeacherRepositoryImpl;
import com.vansisto.students.repositories.impl.StudentsRepositoryImpl;
import com.vansisto.students.repositories.impl.TeacherRepositoryImpl;
import com.vansisto.students.services.StudentServiceImpl;
import com.vansisto.students.services.TeacherServiceImpl;

public class App {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentsRepositoryImpl();
        TeacherRepository teacherRepository = new TeacherRepositoryImpl();
        StudentTeacherRepository studentTeacherRepository = new StudentTeacherRepositoryImpl();

        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();

//        studentRepository.createStudent(new Student("Alpha"));
//        studentRepository.updateStudent(new Student(10, "Beta"));
//        studentRepository.deleteStudent(new Student(4, "Alpha"));
//        System.out.println(studentRepository.getStudentById(3));
//        System.out.println(studentRepository.getAllStudents());

//        teacherRepository.createTeacher(new Teacher("Gamma"));
//        teacherRepository.updateTeacher(new Teacher(1, "Delta"));
//        teacherRepository.deleteTeacher(new Teacher(3, "Gamma"));
//        System.out.println(teacherRepository.getTeacherById(2));
//        System.out.println(teacherRepository.getAllTeacher());

//        studentTeacherRepository.create(new StudentTeacher(1,2));
//        studentTeacherRepository.create(new StudentTeacher(1,1));
//        studentTeacherRepository.create(new StudentTeacher(2,2));
//        studentTeacherRepository.create(new StudentTeacher(3,1));
//        studentTeacherRepository.update(new StudentTeacher(9,3,2));
//        studentTeacherRepository.delete(new StudentTeacher(9, 1, 1));
//        System.out.println(studentTeacherRepository.getById(8));
//        System.out.println(studentTeacherRepository.getAll());

//        System.out.println(studentService.getAllByTeacherId(2));
//        System.out.println(studentService.getAllByTeacherId(1));

//        System.out.println(teacherService.getAllByStudentId(1));
//        System.out.println(teacherService.getAllByStudentId(2));
//        System.out.println(teacherService.getAllByStudentId(3));
    }
}
