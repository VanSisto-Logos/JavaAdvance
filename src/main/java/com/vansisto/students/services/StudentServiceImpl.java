package com.vansisto.students.services;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.StudentTeacher;
import com.vansisto.students.repositories.StudentRepository;
import com.vansisto.students.repositories.StudentTeacherRepository;
import com.vansisto.students.repositories.impl.StudentTeacherRepositoryImpl;
import com.vansisto.students.repositories.impl.StudentsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl {
    private StudentRepository repository = new StudentsRepositoryImpl();
    private StudentTeacherRepository commonRepository = new StudentTeacherRepositoryImpl();

    public void create(Student student) {
        repository.createStudent(student);
    }

    public void update(Student student) {
        repository.updateStudent(student);
    }

    public void delete(Student student) {
        repository.deleteStudent(student);
    }

    public Student getById(int id) {
        return repository.getStudentById(id);
    }

    public List<Student> getAll() {
        return repository.getAllStudents();
    }

    public List<Student> getAllByTeacherId(int id) {
        List<StudentTeacher> common = commonRepository.getAll();
        common = common.stream().filter(c -> c.getTeacher_id() == id).collect(Collectors.toList());

        List<Student> students = getAll();
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++){
            for (int j = 0; j < common.size(); j++){
                if (students.get(i).getStudent_id() == common.get(j).getStudent_id()){
                    result.add(students.get(i));
                }
            }
        }

        return result;
    }

}
