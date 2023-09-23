package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.dto.response.StudentResponse;
import edu.icet.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping
    public StudentResponse retrieveAllStudents(){
        return StudentResponse
                .builder()
                .studentList(studentService.retrieveAllStudents())
                .build();
    }

    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> retrieveStudentByFirstName(
            @PathVariable String firstName){
        return studentService.retrieveStudentByFirstName(firstName);
    }


    @GetMapping("/count")
    public Map retrieveStudentCount(){
        return studentService.retrieveStudentCount();
    }


    @GetMapping("/id/{id}")
    public Map<String, String> retrieveStudentsFirstNameById(
            @PathVariable String id){
        return studentService.retrieveStudentsFirstNameById(id);
    }


    @GetMapping("/batch/{batchId}")
    public Map<String, List> retrieveStudentsFirstNamesByBatch(
            @PathVariable String batchId){
        return studentService.retrieveStudentsFirstNamesByBatch(batchId);
    }


}
