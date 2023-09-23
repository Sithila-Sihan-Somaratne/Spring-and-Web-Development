package edu.icet.repository;

import edu.icet.dao.StudentEntity;

import java.util.List;

public interface NativeStudentRepository {

    Integer retrieveStudentCount();

    Number addStudent(StudentEntity studentEntity);


    String retrieveStudentsFirstNameById(String id);


    List<String> retrieveStudentsFirstNamesByBatch(String batchId);

}
