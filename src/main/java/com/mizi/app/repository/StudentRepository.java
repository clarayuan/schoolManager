package com.mizi.app.repository;

import com.mizi.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cyuan on 1/4/2018.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
