package com.pegs.StudentManagementApp.Controller;

import com.pegs.StudentManagementApp.Model.Student;
import com.pegs.StudentManagementApp.Service.ReportService;
import com.pegs.StudentManagementApp.Service.StudentServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private ReportService reportService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);



    @PostMapping("/Students")
    public Student addStudent(@RequestBody Student student){
        logger.trace("addStudent Method in StudentController is accessed.");
        studentService.save(student);
        logger.trace("Student Obj is saved to Database");
        return student;
    }

    @GetMapping("/Students")
    public List<Student> getStudents(){
        logger.trace("getStudents Method in StudentController is accessed.");
        return studentService.getStudents();


    }

    @GetMapping("/Students/{sid}")
    public Optional<Student> getStudentById(@PathVariable Integer sid){
        logger.trace("getStudentById method is StudentController is accessed.");
        return studentService.getStudentById(sid);
    }

    @PutMapping("Students/{sid}")
    public Student updateStudentById(@PathVariable Integer sid , @RequestBody Student student){
        logger.trace("updateStudentById method in StudentController is accessed.");
        student.setSid(sid);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/Students/{sid}")
    public String deleteStudentById(@PathVariable Integer sid){
        logger.trace("deleteStudentById method in StudentController is accessed.");
        studentService.deleteStudentById(sid);
        return "Deleted..";
    }

    @GetMapping("/Students/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        final String s = reportService.exportReport(format);
        return s;
    }

}
