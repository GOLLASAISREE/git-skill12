package com.example.studentmanagement.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // GET all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // POST add student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // DELETE student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return repo.save(student);
    }
}