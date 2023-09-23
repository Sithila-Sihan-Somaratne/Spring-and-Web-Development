package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dao.TeacherEntity;
import edu.icet.dto.Student;

public interface TeacherService {
    Iterable<TeacherEntity> retrieveAllTeachers();

}
