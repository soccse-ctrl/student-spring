package org.example.demo.controller; // Package declaration

import org.example.demo.model.Students; // Import the Students model (plural)
import org.example.demo.service.StudentService; // Import the service layer
import org.springframework.web.bind.annotation.*; // Import Spring MVC annotations
import java.util.List; // For returning a list of students

// REST API Controller
@RestController // Marks this class as a REST controller (returns JSON)
@RequestMapping("/students") // Base path is /students (fixed typo from /studentss)
public class StudentsController { // Class name plural as per your naming

    private final StudentService service; // Reference to the service layer

    // Constructor injection for StudentService
    public StudentsController(StudentService service) {
        this.service = service;
    }

    // GET /students → Get all students
    @GetMapping
    public List<Students> getAll() {
        return service.getAllStudents(); // Delegate to service to fetch all students
    }

    // GET /students/{id} → Get a student by their ID
    @GetMapping("/{id}")
    public Students getById(@PathVariable int id) {
        return service.getStudent(id); // Delegate to service to fetch student by ID
    }

    // POST /students → Add a new student
    @PostMapping
    public void add(@RequestBody Students student) {
        service.addStudent(student); // Delegate to service to save the student
    }

    // PUT /students/{id} → Update an existing student
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Students student) {
        student.setId(id); // Set the path variable ID into the student object
        service.updateStudent(student); // Delegate to service to update the student
    }

    // DELETE /students/{id} → Delete a student by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteStudent(id); // Delegate to service to delete the student
    }
}
