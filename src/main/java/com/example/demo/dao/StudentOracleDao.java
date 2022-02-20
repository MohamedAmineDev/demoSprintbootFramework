package com.example.demo.dao;

import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OracleStudentDAO")
public class StudentOracleDao extends StudientDao {
    public StudentOracleDao(List<Studient> studients) {
        super(studients);
    }

    @Override
    public boolean insertData(Studient studient) {
        return super.insertData(studient);
    }

    @Override
    public List<Studient> selectAllStudients() {
        return super.selectAllStudients();
    }

    @Override
    public boolean deleteStudient(int id) throws NotPositiveException {
        return super.deleteStudient(id);
    }

    @Override
    public boolean updateStudient(int id, Studient studient) throws NotPositiveException {
        return super.updateStudient(id, studient);
    }

    @Override
    public Studient selectOneStudent(int id) throws NotPositiveException {
        return super.selectOneStudent(id);
    }
}
