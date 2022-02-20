package com.example.demo.dao;

import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;

import java.util.List;

public interface IStudientDao {
    boolean insertData(Studient studient);

    List<Studient> selectAllStudients();

    boolean deleteStudient(int id) throws NotPositiveException;

    boolean updateStudient(int id, Studient studient) throws NotPositiveException;

    Studient selectOneStudent(int id) throws NotPositiveException;
}
