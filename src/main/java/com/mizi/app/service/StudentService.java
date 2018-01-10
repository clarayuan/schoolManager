package com.mizi.app.service;

import com.mizi.app.model.Student;
import com.mizi.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cyuan on 1/9/2018.
 */
public interface StudentService {
    List<Student> findAll();
    Student findOne(Long id);
    Student save(Student student);
    void delete(Student student);
}
