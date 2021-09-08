package com.bogdan.webapp.controller;

import com.bogdan.webapp.entity.Student;
import com.bogdan.webapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Employee is not found " + studentId );
        }

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(Student student) {
        student.setId(0);

        studentService.save(student);

        return student;
    }

    @PutMapping("/students")
    public Student saveStudent(Student student) {

        studentService.save(student);

        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Students does not exist " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted student id  " + studentId;
    }
}
