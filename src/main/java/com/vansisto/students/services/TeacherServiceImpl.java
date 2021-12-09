package com.vansisto.students.services;

import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.StudentTeacher;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.repositories.StudentTeacherRepository;
import com.vansisto.students.repositories.TeacherRepository;
import com.vansisto.students.repositories.impl.StudentTeacherRepositoryImpl;
import com.vansisto.students.repositories.impl.TeacherRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherServiceImpl {
    private TeacherRepository repository = new TeacherRepositoryImpl();
    private StudentTeacherRepository commonRepository = new StudentTeacherRepositoryImpl();

    public void create(Teacher teacher){
        repository.createTeacher(teacher);
    }

    public void update(Teacher teacher){
        repository.updateTeacher(teacher);
    }

    public void delete(Teacher teacher){
        repository.deleteTeacher(teacher);
    }

    public void getById(int id){
        repository.getTeacherById(id);
    }

    public List<Teacher> getAll(){
        return repository.getAllTeacher();
    }

    public List<Teacher> getAllByStudentId(int id){
        List<StudentTeacher> common = commonRepository.getAll();
        common = common.stream().filter(c -> c.getStudent_id() == id).collect(Collectors.toList());

        List<Teacher> teachers = getAll();
        List<Teacher> result = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++){
            for (int j = 0; j < common.size(); j++){
                if (teachers.get(i).getTeacher_id() == common.get(j).getTeacher_id()){
                    result.add(teachers.get(i));
                }
            }
        }

        return result;
    }
}
