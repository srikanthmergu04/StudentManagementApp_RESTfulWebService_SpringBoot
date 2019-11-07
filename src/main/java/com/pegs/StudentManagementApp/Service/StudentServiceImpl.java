package com.pegs.StudentManagementApp.Service;

import com.pegs.StudentManagementApp.Dao.StudentDaoImpl;
import com.pegs.StudentManagementApp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDaoImpl studentDao;

    @Caching(
            put = {@CachePut(cacheNames = "StudentCache" , key = "#student.sid")} ,
            evict = {@CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)}
    )
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Cacheable(cacheNames = "AllStudentsCache")
    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    @Cacheable(cacheNames = "StudentCache" , key = "#sid")
    public Optional<Student> getStudentById(Integer sid) {
        return studentDao.findById(sid);
    }


    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "StudentCache" , key = "#sid") ,
                    @CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)
            }
    )
    public void deleteStudentById(Integer sid) {
        studentDao.deleteById(sid);
    }

    @Caching(
            put = {@CachePut(cacheNames = "StudentCache" , key = "#student.sid")} ,
            evict = {@CacheEvict(cacheNames = "AllStudentsCache" , allEntries = true)}
    )
    public Student updateStudent(Student student) {
        return studentDao.save(student);
    }
}
