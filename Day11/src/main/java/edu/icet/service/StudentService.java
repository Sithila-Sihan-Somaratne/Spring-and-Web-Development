package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    void createStudent(Student student);

    List<Student>  retrieveAllStudents();

    Iterable<StudentEntity> retrieveStudentByFirstName(String firstName);

    Map retrieveStudentCount();


    Map<String, String> retrieveStudentsFirstNameById(String id);

    Map<String, List> retrieveStudentsFirstNamesByBatch(String batchId);

}
