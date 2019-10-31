package com.pegs.StudentManagementApp.Controller;

import com.pegs.StudentManagementApp.Model.Student;
import com.pegs.StudentManagementApp.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/Students")
    public Student addStudent(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @GetMapping("/Students")
    public List<Student> getStudents(){
        return studentService.getStudents();

    }

    @GetMapping("/Students/{sid}")
    public Optional<Student> getStudentById(@PathVariable Integer sid){
        return studentService.getStudentById(sid);
    }

    @PutMapping("Students/{sid}")
    public Student updateStudentById(@PathVariable Integer sid , @RequestBody Student student){
        student.setSid(sid);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/Students/{sid}")
    public String deleteStudentById(@PathVariable Integer sid){

        studentService.deleteStudentById(sid);
        return "Deleted..";
    }

}
