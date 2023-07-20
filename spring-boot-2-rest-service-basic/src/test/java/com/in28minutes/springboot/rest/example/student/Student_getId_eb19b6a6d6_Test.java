// Test generated by RoostGPT for test packagelevel using AI Type Open AI and AI Model gpt-4

package com.in28minutes.springboot.rest.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Student_getId_eb19b6a6d6_Test {

    @InjectMocks
    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetIdSuccess() {
        Long expectedId = 123L;
        student.setId(expectedId);
        Long actualId = student.getId();
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetIdWhenIdNotSet() {
        Long actualId = student.getId();
        assertEquals(null, actualId);
    }
}
