package edu.icet.repository;

import edu.icet.dao.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository
        extends CrudRepository<StudentEntity,Long> {

    Iterable<StudentEntity> findAllByFirstName(String firstName);

    Iterable<StudentEntity> findAllByLastName(String lastName);

    void deleteAllByLastName(String lastName);

}
