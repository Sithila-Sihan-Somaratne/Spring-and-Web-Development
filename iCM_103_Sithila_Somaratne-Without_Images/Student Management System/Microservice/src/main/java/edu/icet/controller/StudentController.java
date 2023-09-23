package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialBlob;


@RestController
@Slf4j
@CrossOrigin
@RequestMapping()
public class StudentController {
    private String image;
    @Autowired
    StudentService studentService;
    @PostMapping("/post-student")
    public void sendStudent(@RequestBody Student student) throws SQLException {
        image = student.getStudentImage();
        byte[] decoded = Base64.getMimeDecoder().decode(image);
        Blob b = new SerialBlob(decoded);
        studentService.sendStudent(student,b);
    }
    @GetMapping("/view-student")
    public List<Student> retrieveStudents(){
        return studentService.retrieveStudents(image);
    }

}
