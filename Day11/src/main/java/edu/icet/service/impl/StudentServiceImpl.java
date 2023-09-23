package edu.icet.service.impl;

import edu.icet.dto.Student;
import edu.icet.dao.StudentEntity;
import edu.icet.repository.NativeStudentRepository;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${student.institute}")
    String institute;


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    NativeStudentRepository nativeStudentRepository;


    public void createStudent(Student student){
        StudentEntity model = new StudentEntity();
        model.setFirstName(student.getFirstName());
        model.setLastName(student.getLastName());
        model.setBatch(student.getBatch());
        model.setInstitute(institute);
        //studentRepository.save(model);
        nativeStudentRepository.addStudent(model);
    }

    public List<Student> retrieveAllStudents(){

        Iterable<StudentEntity> studentList = studentRepository.findAll();

        List<Student> studentModelList = new ArrayList<>();

        Iterator<StudentEntity> iterator = studentList.iterator();

        while (iterator.hasNext()){

            StudentEntity studentDao = iterator.next();

            //Model Mapping
            studentModelList.add(
                        Student.builder()
                            .batch(studentDao.getBatch())
                            .firstName(studentDao.getFirstName())
                            .lastName(studentDao.getLastName())
                            .build()
            );
        }
        return studentModelList;
    }


    public Iterable<StudentEntity> retrieveStudentByFirstName(String firstName){
        return studentRepository.findAllByFirstName(firstName);
    }

    public Iterable<StudentEntity> retrieveStudentByLstName(String lastName){
        return studentRepository.findAllByFirstName(lastName);
    }



    public Map retrieveStudentCount(){
        return Collections.singletonMap("studentCount",
                nativeStudentRepository.retrieveStudentCount());
    }



    public Map<String, String> retrieveStudentsFirstNameById(String id){
        return Collections.singletonMap("studentFirstName",
                nativeStudentRepository.retrieveStudentsFirstNameById(id));
    }


    public Map<String, List> retrieveStudentsFirstNamesByBatch(String batchId){
        return Collections.singletonMap("studentFirstName",
                nativeStudentRepository.retrieveStudentsFirstNamesByBatch(batchId));
    }


}

