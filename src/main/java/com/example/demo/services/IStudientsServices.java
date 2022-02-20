package com.example.demo.services;

import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;

import java.util.List;

public interface IStudientsServices {
    int addStudient(Studient studient);

    int updateStudient(int id, Studient studient) throws NotPositiveException;

    int deleteStudient(int id) throws NotPositiveException;

    List<Studient> getStudients();

    Studient getStudentById(int id) throws NotPositiveException;
}
