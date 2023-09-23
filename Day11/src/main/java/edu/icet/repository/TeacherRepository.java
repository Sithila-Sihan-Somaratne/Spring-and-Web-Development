package edu.icet.repository;

import edu.icet.dao.StudentEntity;
import edu.icet.dao.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository
        extends CrudRepository<TeacherEntity,Long> {

    Iterable<TeacherEntity> findAllByFirstName(String firstName);

    Iterable<TeacherEntity> findAllByLastName(String lastName);
}
