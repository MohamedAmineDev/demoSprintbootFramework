package com.example.demo.api;

import com.example.demo.model.Studient;

import java.util.List;

public interface IStudientController {
    String addStudent(Studient studient);

    String updateStudent(int id, Studient studient);

    String deleteStudent(int id);

    List<Studient> getAllStudents();

    Studient getStudent(int id);
}
