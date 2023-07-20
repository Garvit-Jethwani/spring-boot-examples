package com.in28minutes.springboot.rest.example.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentResource_updateStudent_7950432514_Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testUpdateStudent_Success() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setCourse("Science");
        given(studentRepository.findById(1L)).willReturn(Optional.of(student));

        mvc.perform(MockMvcRequestBuilders.put("/students/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testUpdateStudent_NotFound() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setCourse("Science");
        given(studentRepository.findById(1L)).willReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.put("/students/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isNotFound());
    }
}
