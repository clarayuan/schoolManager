package com.mizi.app.controller;

import com.mizi.app.model.Student;
import com.mizi.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by cyuan on 1/5/2018.
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // Get All Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @Valid @RequestBody Student studentDetails) {
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setName(studentDetails.getName());
        student.setCountry(studentDetails.getCountry());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
