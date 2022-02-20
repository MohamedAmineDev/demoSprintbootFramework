package com.example.demo.api;

import com.example.demo.exceptions.NotPositiveException;
import com.example.demo.model.Studient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;
import com.example.demo.services.StudientService;

import java.util.List;

@RequestMapping("api")
@RestController
public class StudientController implements IStudientController {
    private final StudientService studentService;
    private static int defaultId = 0;

    @Autowired
    public StudientController(@Qualifier("StudentService") StudientService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @Override
    public String addStudent(@RequestBody Studient studient) {

        try {
            if (studient.getId() < 0) {
                throw new NotPositiveException("The addition of the student failed because the id must be positive !!!!");
            }
            defaultId++;
            studient.setId(defaultId);
            studentService.addStudient(studient);
            return "The addition of the student is a success !";
        } catch (NotPositiveException notPositiveException) {
            return notPositiveException.getMessage();
        } catch (Exception e) {
            return "The addition of the student failed because " + e.getMessage();
        }
    }

    @PutMapping(path = "{id}")
    @Override
    public String updateStudent(@PathVariable("id") int id, @RequestBody Studient studient) {

        try {
            if (id < 0 || studient.getId() < 0) {
                throw new NotPositiveException("The update of the student failed because the id must be positive !!!!");
            }
            studentService.updateStudient(id, studient);
            return "The update of the student is a success !";
        } catch (NotPositiveException notPositiveException) {
            return notPositiveException.getMessage();
        } catch (Exception e) {
            return "The addition of the student failed because " + e.getMessage();
        }
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public String deleteStudent(@PathVariable("id") int id) {
        try {
            if (id < 0) {
                throw new NotPositiveException("The deletion of the student failed because the id must be positive !!!!");
            }
            studentService.deleteStudient(id);
            return "The deletion of the student is a success !";
        } catch (NotPositiveException notPositiveException) {
            return notPositiveException.getMessage();
        } catch (Exception e) {
            return "The deletion of the student failed because " + e.getMessage();
        }
    }

    @GetMapping
    @Override
    public List<Studient> getAllStudents() {

        return studentService.getStudients();
    }

    @GetMapping(path = "/{id}")
    @Override
    public Studient getStudent(@PathVariable("id") int id) {
        try {
            if (id < 0) {
                throw new NotPositiveException("The student is not found because the id is not positve !!!!");
            }
            return studentService.getStudentById(id);
        } catch (NotPositiveException notPositiveException) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
