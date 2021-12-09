package com.vansisto.students.repositories.impl;

import com.vansisto.students.MySQLConnector;
import com.vansisto.students.dao.Student;
import com.vansisto.students.dao.Teacher;
import com.vansisto.students.repositories.TeacherRepository;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TeacherRepositoryImpl implements TeacherRepository {
    private final Connection connection = MySQLConnector.getConnection();

    @Override
    public void createTeacher(Teacher teacher) {
        boolean hasId = teacher.getTeacher_id() != 0;
        String query = hasId ?
                "INSERT INTO teachers(name, teacher_id) VALUES(?, ?)" :
                "INSERT INTO teachers(name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, teacher.getName());
            if (hasId)
                statement.setInt(2, teacher.getTeacher_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE teachers SET name = ? WHERE teacher_id = ?"
        )) {
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getTeacher_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM teachers WHERE teacher_id = ?"
        )) {
            statement.setInt(1, teacher.getTeacher_id());
            statement.execute();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers WHERE teacher_id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            Teacher teacher = new Teacher(resultSet.getInt("teacher_id"), resultSet.getString("name"));
            return teacher;
        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM teachers");
            while (resultSet.next()){
                teachers.add(
                        new Teacher(
                                resultSet.getInt("teacher_id"),
                                resultSet.getString("name")
                        )
                );
            }

            return teachers;
        } catch (SQLException e ) {
            log.error(e);
        }

        return null;
    }
}
