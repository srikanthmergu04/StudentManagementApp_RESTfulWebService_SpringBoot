package com.pegs.StudentManagementApp.Service;

import com.pegs.StudentManagementApp.Dao.StudentDaoImpl;
import com.pegs.StudentManagementApp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDaoImpl studentDao;

    public void save(Student student) {
        studentDao.save(student);
    }

    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    public Optional<Student> getStudentById(Integer sid) {
        return studentDao.findById(sid);
    }

    public void deleteStudentById(Integer sid) {
        studentDao.deleteById(sid);
    }

    public Student updateStudent(Student student) {
        return studentDao.save(student);
    }
}
