package edu.icet.service;

import edu.icet.dto.Student;

import java.sql.Blob;
import java.util.List;

public interface StudentService {
    void sendStudent(Student student, Blob blob);

    List<Student> retrieveStudents(String image);
}
