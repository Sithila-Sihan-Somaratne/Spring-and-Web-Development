package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.dto.Teacher;
import edu.icet.service.StudentService;
import edu.icet.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public void retrieveAllTeachers(){
        teacherService.retrieveAllTeachers();
    }

}
