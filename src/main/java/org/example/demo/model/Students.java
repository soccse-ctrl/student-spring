package org.example.demo.model;

// Student model (maps to DB table `students`)
public class Students {
    private int id;        // primary key
    private String name;   // student name
    private int age;       // student age
    private String course; // student course

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
