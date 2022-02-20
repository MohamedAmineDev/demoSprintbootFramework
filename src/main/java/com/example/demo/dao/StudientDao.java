package com.example.demo.dao;

import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDAO")
public class StudientDao implements IStudientDao {
    private final List<Studient> studients;

    public StudientDao(List<Studient> studients) {
        this.studients = studients;
    }

    @Override
    public boolean insertData(Studient studient) {
        return studients.add(studient);
    }

    @Override
    public List<Studient> selectAllStudients() {
        return studients;
    }

    @Override
    public boolean deleteStudient(int id) throws NotPositiveException {
        Studient s = new Studient();
        s.setId(id);
        int index = studients.indexOf(s);
        if (index < 0) {
            throw new NotPositiveException("The deletion of the student failed because the id is not found !!!!");
        }
        return studients.remove(studients.get(index));
    }

    @Override
    public boolean updateStudient(int id, Studient studient) throws NotPositiveException {
        Studient s = new Studient();
        s.setId(id);
        int index = studients.indexOf(s);
        if (index < 0) {
            throw new NotPositiveException("The update of the student failed because the id is not found !!!!");
        }
        studient.setId(id);
        s = studients.set(index, studient);
        return s != null;
    }

    @Override
    public Studient selectOneStudent(int id) throws NotPositiveException {
        Studient s = new Studient();
        s.setId(id);
        int index = studients.indexOf(s);
        if (index < 0) {
            throw new NotPositiveException("The  student is not found !!!!");
        }
        return studients.get(index);
    }
}
