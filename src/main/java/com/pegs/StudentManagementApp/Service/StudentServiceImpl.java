package com.pegs.StudentManagementApp.Service;

import com.pegs.StudentManagementApp.Controller.StudentController;
import com.pegs.StudentManagementApp.Dao.StudentDaoImpl;
import com.pegs.StudentManagementApp.Model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDaoImpl studentDao;

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Caching(
            put = {@CachePut(cacheNames = "StudentCache" , key = "#student.sid")} ,
            evict = {@CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)}
    )
    public Student save(Student student) {
        logger.info(student+" Obj is saved to Database");
        logger.info(student+" Obj is saved to Cache");
        return studentDao.save(student);
    }

    @Cacheable(cacheNames = "AllStudentsCache")
    public List<Student> getStudents() {
        List<Student> studentsList = studentDao.findAll();
        logger.info(studentsList+" are returned from Database");
        return studentsList;
    }

    @Cacheable(cacheNames = "StudentCache" , key = "#sid")
    public Optional<Student> getStudentById(Integer sid) {
        Optional<Student> student = studentDao.findById(sid);
        logger.info(student+" Student returned from Database");
        return student;
    }


    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "StudentCache" , key = "#sid") ,
                    @CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)
            }
    )
    public void deleteStudentById(Integer sid) {
        Optional<Student> student = getStudentById(sid);
        logger.info(student+" Obj is deleted from Database");
        logger.info(student+" Obj is deleted from Cache");
        studentDao.deleteById(sid);
    }

    @Caching(
            put = {@CachePut(cacheNames = "StudentCache" , key = "#student.sid")} ,
            evict = {@CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)}
    )
    public Student updateStudent(Student student) {
        logger.info(student+"Student Obj in Database updated");
        logger.info(student+"Student Obj in Cache updated");
        return studentDao.save(student);
    }
}
