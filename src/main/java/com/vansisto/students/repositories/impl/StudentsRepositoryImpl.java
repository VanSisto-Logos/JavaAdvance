package com.vansisto.students.repositories.impl;

import com.vansisto.students.MySQLConnector;
import com.vansisto.students.dao.Student;
import com.vansisto.students.repositories.StudentRepository;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class StudentsRepositoryImpl implements StudentRepository {
    Connection connection = MySQLConnector.getConnection();


    @Override
    public void createStudent(Student student) {
        boolean hasId = student.getStudent_id() != 0;
        String query = hasId ?
                "INSERT INTO students(name, student_id) VALUES (?, ?)" :
                "INSERT INTO students(name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getName());
            if (hasId)
                statement.setInt(2, student.getStudent_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        if (isExist(student)){
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET name = ? WHERE student_id = ?"
            )) {
                statement.setString(1, student.getName());
                statement.setInt(2, student.getStudent_id());
                statement.execute();
            } catch (SQLException e) {
                log.error(e);
            }
        }
    }

    private boolean isExist(Student student) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM students WHERE student_id = ?"
        )) {
            statement.setInt(1, student.getStudent_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
            return false;
        }
        return true;
    }

    @Override
    public void deleteStudent(Student student) {
        if (isExist(student)){
            try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM students WHERE student_id = ?"
            )) {
                statement.setInt(1, student.getStudent_id());
                statement.execute();
            } catch (SQLException e) {
                log.error(e);
            }
        }
    }

    @Override
    public Student getStudentById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE student_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            Student student = new Student(resultSet.getInt("student_id"), resultSet.getString("name"));
            return student;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                students.add(
                        new Student(
                                resultSet.getInt("student_id"),
                                resultSet.getString("name")
                        )
                );
            }

            return students;
        } catch (SQLException e ) {
            log.error(e);
        }

        return null;
    }
}
