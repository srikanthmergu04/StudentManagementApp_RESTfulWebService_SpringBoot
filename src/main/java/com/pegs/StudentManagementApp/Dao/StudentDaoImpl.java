package com.pegs.StudentManagementApp.Dao;

import com.pegs.StudentManagementApp.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDaoImpl extends JpaRepository<Student , Integer> {
}
