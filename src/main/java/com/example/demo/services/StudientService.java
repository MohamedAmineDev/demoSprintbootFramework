package com.example.demo.services;

import com.example.demo.dao.IStudientDao;
import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;
import com.example.demo.services.IStudientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public class StudientService implements IStudientsServices {
    private final IStudientDao database;

    /*@Autowired
    public StudientService(@Qualifier("studentDAO") IStudientDao database) {
        this.database = database;
    }*/
    /*OracleStudentDAO*/
    @Autowired
    public StudientService(@Qualifier("OracleStudentDAO") IStudientDao database) {
        this.database = database;
    }

    @Override
    public int addStudient(Studient studient) {
        boolean test = database.insertData(studient);
        if (test) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int updateStudient(int id, Studient studient) throws NotPositiveException {
        boolean test = database.updateStudient(id, studient);
        if (test) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteStudient(int id) throws NotPositiveException {
        boolean test = database.deleteStudient(id);
        if (test) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public List<Studient> getStudients() {
        return database.selectAllStudients();
    }

    @Override
    public Studient getStudentById(int id) throws NotPositiveException {
        return database.selectOneStudent(id);
    }
}
