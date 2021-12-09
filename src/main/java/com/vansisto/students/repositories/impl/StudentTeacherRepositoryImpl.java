package com.vansisto.students.repositories.impl;

import com.vansisto.students.MySQLConnector;
import com.vansisto.students.dao.StudentTeacher;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.repositories.StudentTeacherRepository;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class StudentTeacherRepositoryImpl implements StudentTeacherRepository {
    Connection connection = MySQLConnector.getConnection();

    @Override
    public void create(StudentTeacher studentTeacher) {
        boolean isThreeValues = studentTeacher.getStudents_teachers_id() != 0;
        String SQL = isThreeValues ?
                "INSERT INTO students_teachers(student_id, teacher_id, students_teachers_id) VALUES (?, ?, ?)":
                "INSERT INTO students_teachers(student_id, teacher_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, studentTeacher.getStudent_id());
            statement.setInt(2, studentTeacher.getTeacher_id());
            if (isThreeValues)
                statement.setInt(3, studentTeacher.getStudents_teachers_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void update(StudentTeacher studentTeacher) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE students_teachers SET student_id = ?, teacher_id = ? WHERE students_teachers_id = ?"
        )) {
            statement.setInt(1, studentTeacher.getStudent_id());
            statement.setInt(2, studentTeacher.getTeacher_id());
            statement.setInt(3, studentTeacher.getStudents_teachers_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void delete(StudentTeacher studentTeacher) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM students_teachers WHERE students_teachers_id = ?"
        )) {
            statement.setInt(1, studentTeacher.getStudents_teachers_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public StudentTeacher getById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM students_teachers WHERE students_teachers_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            StudentTeacher studentTeacher = new StudentTeacher(
                    resultSet.getInt("students_teachers_id"),
                    resultSet.getInt("student_id"),
                    resultSet.getInt("teacher_id")
            );
            return studentTeacher;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public List<StudentTeacher> getAll() {
        List<StudentTeacher> studentTeachers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_teachers");
            while (resultSet.next()){
                studentTeachers.add(
                        new StudentTeacher(
                                resultSet.getInt("students_teachers_id"),
                                resultSet.getInt("student_id"),
                                resultSet.getInt("teacher_id")
                        )
                );
            }

            return studentTeachers;
        } catch (SQLException e ) {
            log.error(e);
        }

        return null;
    }
}
