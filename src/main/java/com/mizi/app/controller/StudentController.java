package com.mizi.app.controller;

import com.mizi.app.model.Student;
import com.mizi.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by cyuan on 1/5/2018.
 */
@RestController
@RequestMapping("/api")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/async")
    public DeferredResult<List<Student>> getAllStudentsAsync() {
        DeferredResult<List<Student>> defResult = new DeferredResult<>();

        new Thread(() -> {
            List<Student> students = studentService.findAll();

            try {
                Thread.sleep(1000);
            }
            catch (Exception ee) {

            }
            defResult.setResult(students);
        }).start();

        return defResult;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student newStudent =  studentService.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId) {
        Student student = studentService.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @Valid @RequestBody Student studentDetails) {
        Student student = studentService.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setName(studentDetails.getName());
        student.setCountry(studentDetails.getCountry());

        Student updatedStudent = studentService.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.findOne(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(student);
        return ResponseEntity.ok().build();
    }
}
