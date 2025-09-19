package org.example.demo.service; // Package declaration

import org.example.demo.model.Students; // Import the Students model (plural)
import org.example.demo.repository.StudentRepository; // Import the repository that talks to the DB
import org.springframework.stereotype.Service; // Marks this as a Spring service component
import java.util.List; // For returning a list of students

// Service layer = sits between the controller and the repository
// Handles business logic (if any) and delegates DB calls to the repository
@Service // Tells Spring to treat this class as a service bean
public class StudentService {

    private final StudentRepository repo; // Reference to the StudentRepository

    // Constructor injection of the repository
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Return all students by calling the repository
    public List<Students> getAllStudents() {
        return repo.findAll();
    }

    // Return a single student by ID
    public Students getStudent(int id) {
        return repo.findById(id);
    }

    // Add a new student
    public void addStudent(Students student) {
        repo.save(student);
    }

    // Update an existing student
    public void updateStudent(Students student) {
        repo.update(student);
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
