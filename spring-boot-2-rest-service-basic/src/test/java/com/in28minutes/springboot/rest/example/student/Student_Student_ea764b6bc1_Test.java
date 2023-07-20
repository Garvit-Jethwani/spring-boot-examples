package com.in28minutes.springboot.rest.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Student_Student_ea764b6bc1_Test {

    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student(1L, "John Doe", "AB123456");
    }

    @Test
    public void testStudentConstructor() {
        assertEquals(1L, student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals("AB123456", student.getPassportNumber());
    }

    @Test
    public void testStudentConstructorWithNulls() {
        Student studentWithNulls = new Student(null, null, null);
        assertNotNull(studentWithNulls);
    }
}
