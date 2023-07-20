package com.in28minutes.springboot.rest.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.in28minutes.springboot.rest.example.student.Student;
import com.in28minutes.springboot.rest.example.student.StudentRepository;
import com.in28minutes.springboot.rest.example.student.StudentResource;

public class StudentResource_createStudent_057afb4be1_Test {

    @InjectMocks
    StudentResource studentResource;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateStudent_Success() throws URISyntaxException {
        Student student = new Student();
        student.setName("Test");
        student.setDescription("Test");
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        ResponseEntity<Object> responseEntity = studentResource.createStudent(student);
        assertEquals(201, responseEntity.getStatusCodeValue());

        URI expectedLocation = new URI("/students/1");
        assertEquals(expectedLocation, responseEntity.getHeaders().getLocation());
    }

    @Test
    public void testCreateStudent_Failure() {
        when(studentRepository.save(any(Student.class))).thenReturn(null);

        Student student = new Student();
        student.setName("Test");
        student.setDescription("Test");
        ResponseEntity<Object> responseEntity = studentResource.createStudent(student);
        assertEquals(500, responseEntity.getStatusCodeValue());
    }
}
