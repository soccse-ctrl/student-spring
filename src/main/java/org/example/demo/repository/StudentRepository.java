package org.example.demo.repository; // Package declaration

import org.example.demo.model.Students; // Import the Students model
import org.springframework.jdbc.core.JdbcTemplate; // For executing SQL queries
import org.springframework.jdbc.core.RowMapper; // For mapping rows of a ResultSet to Java objects
import org.springframework.stereotype.Repository; // Marks the class as a Spring-managed repository bean
import java.util.List; // For returning lists of students

@Repository // Indicates that this class is a Spring component responsible for database interaction
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate; // JdbcTemplate handles database operations

    // Constructor-based dependency injection
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper to convert each row in the ResultSet to a Students object
    private final RowMapper<Students> rowMapper = (rs, rowNum) -> {
        Students s = new Students(); // Create a new Students object
        s.setId(rs.getInt("id")); // Map 'id' column from ResultSet to Students.id
        s.setName(rs.getString("name")); // Map 'name' column
        s.setAge(rs.getInt("age")); // Map 'age' column
        s.setCourse(rs.getString("course")); // Map 'course' column
        return s; // Return the mapped Students object
    };

    // Retrieve all students from the database
    public List<Students> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", rowMapper); // Run SELECT query and map results
    }

    // Retrieve a student by their ID
    public Students findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM students WHERE id = ?", // SQL query with a parameter placeholder
                rowMapper, // RowMapper to convert the result
                id // Parameter value
        );
    }

    // Save a new student to the database
    public int save(Students student) {
        return jdbcTemplate.update(
                "INSERT INTO students(name, age, course) VALUES (?, ?, ?)", // SQL insert query
                student.getName(), // Replace first ? with student's name
                student.getAge(), // Replace second ? with age
                student.getCourse() // Replace third ? with course
        );
    }

    // Update an existing student record
    public int update(Students student) {
        return jdbcTemplate.update(
                "UPDATE students SET name=?, age=?, course=? WHERE id=?", // SQL update query
                student.getName(), // New name
                student.getAge(), // New age
                student.getCourse(), // New course
                student.getId() // ID of the student to update
        );
    }

    // Delete a student by their ID
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM students WHERE id=?", id); // Run DELETE query
    }
}
