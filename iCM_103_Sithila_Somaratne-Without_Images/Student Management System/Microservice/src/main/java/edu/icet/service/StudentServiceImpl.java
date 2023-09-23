package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.*;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    public void sendStudent(Student student, Blob blob){
        StudentEntity model = new StudentEntity();
        model.setStudentFullName(student.getStudentFullName());
        model.setStudentAddress(student.getStudentAddress());
        model.setStudentEmail(student.getStudentEmail());
        model.setStudentContact(student.getStudentContact());
        model.setStudentSchool(student.getStudentSchool());
        model.setStudentGrade(student.getStudentGrade());
        model.setStudentImage(blob.toString());
        studentRepository.save(model);
    }

    public List<Student> retrieveStudents(String image){
        Iterable<StudentEntity> studentList = studentRepository.findAll();
        List<Student> studentModelList = new ArrayList<>();
        Iterator<StudentEntity> iterator = studentList.iterator();
        if (iterator.hasNext()) {
            do {
                StudentEntity studentDao = iterator.next();
                //Model Mapping
                studentModelList.add(
                        Student.builder()
                                .studentFullName(studentDao.getStudentFullName())
                                .studentAddress(studentDao.getStudentAddress())
                                .studentEmail(studentDao.getStudentEmail())
                                .studentContact(studentDao.getStudentContact())
                                .studentSchool(studentDao.getStudentSchool())
                                .studentGrade(studentDao.getStudentGrade())
                                .studentImage(image)
                                .build()
                );
            } while (iterator.hasNext());
        }
        return studentModelList;
    }
}
