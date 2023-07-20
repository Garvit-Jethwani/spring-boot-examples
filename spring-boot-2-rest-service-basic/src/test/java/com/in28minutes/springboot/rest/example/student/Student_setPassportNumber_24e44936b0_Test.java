package com.in28minutes.springboot.rest.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Student_setPassportNumber_24e44936b0_Test {
  
  public class StudentService {
    private Student student;

    public void setPassportNumber(String passportNumber) {
      student.setPassportNumber(passportNumber);
    }
  }

  @Mock
  private Student student;

  @InjectMocks
  private StudentService studentService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSetPassportNumber_ValidNumber() {
    String passportNumber = "123456789";
    when(student.getPassportNumber()).thenReturn(passportNumber);
    studentService.setPassportNumber(passportNumber);
    assertEquals(passportNumber, student.getPassportNumber());
  }

  @Test
  public void testSetPassportNumber_NullNumber() {
    String passportNumber = null;
    when(student.getPassportNumber()).thenReturn(passportNumber);
    studentService.setPassportNumber(passportNumber);
    assertEquals(passportNumber, student.getPassportNumber());
  }
}
