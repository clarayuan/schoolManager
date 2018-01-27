package com.mizi.app.repository;

import com.mizi.app.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cyuan on 1/8/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenFindAll() {
        Student firstStudent = new Student();
        firstStudent.setName("zhang san");
        firstStudent.setCountry("China");
        studentRepository.save(firstStudent);

        List<Student> studentList = studentRepository.findAll();

        assertThat(studentList.size()).isEqualTo(4);
        assertThat(firstStudent.getCreatedAt()).isNotNull();
    }

}