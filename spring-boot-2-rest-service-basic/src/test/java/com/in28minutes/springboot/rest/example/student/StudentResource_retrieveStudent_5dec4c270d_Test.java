package com.in28minutes.springboot.rest.example.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentResource_retrieveStudent_5dec4c270d_Test {

    @InjectMocks
    StudentResource studentResource;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void testRetrieveStudent_Success() {
        Student student = new Student();
        student.setId(1L);
        student.setName("John");
        // Assuming there is a method setGrade in Student class
        student.setGrade("A");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student returnedStudent = studentResource.retrieveStudent(1L);

        assertEquals("John", returnedStudent.getName());
        // Assuming there is a method getGrade in Student class
        assertEquals("A", returnedStudent.getGrade());
    }

    @Test
    public void testRetrieveStudent_StudentNotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> {
            studentResource.retrieveStudent(1L);
        });
    }
}
