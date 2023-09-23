package edu.icet.service.impl;

import edu.icet.dao.StudentEntity;
import edu.icet.dao.TeacherEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import edu.icet.repository.TeacherRepository;
import edu.icet.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Value("${student.institute}")
    String institute;


    @Autowired
    TeacherRepository teacherRepository;

    public Iterable<TeacherEntity> retrieveAllTeachers(){
        return teacherRepository.findAll();
    }



}

