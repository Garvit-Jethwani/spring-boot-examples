package com.in28minutes.springboot.rest.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentResource_retrieveAllStudents_73e299dfa5_Test {

    @InjectMocks
    StudentResource studentResource;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStudents() {
        Student student1 = new Student();
        student1.setId(1L);
        student1.setName("John");
        student1.setGrade("A");
        
        Student student2 = new Student();
        student2.setId(2L);
        student2.setName("Jane");
        student2.setGrade("B");
        
        List<Student> expectedStudents = Arrays.asList(student1, student2);

        when(studentRepository.findAll()).thenReturn(expectedStudents);

        List<Student> actualStudents = studentResource.retrieveAllStudents();

        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testRetrieveAllStudents_empty() {
        List<Student> expectedStudents = Arrays.asList();

        when(studentRepository.findAll()).thenReturn(expectedStudents);

        List<Student> actualStudents = studentResource.retrieveAllStudents();

        assertEquals(expectedStudents, actualStudents);
    }
}
