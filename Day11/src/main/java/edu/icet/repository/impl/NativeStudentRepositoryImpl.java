package edu.icet.repository.impl;


import edu.icet.dao.StudentEntity;
import edu.icet.repository.NativeStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NativeStudentRepositoryImpl implements NativeStudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer retrieveStudentCount(){
        return jdbcTemplate.queryForObject(
                "SELECT count(*) FROM student_entity;",
                Integer.class);
    }

    public Number addStudent(StudentEntity studentEntity){
        return jdbcTemplate.update(
                "INSERT INTO student_entity VALUES(?,?,?,?,?);",
                studentEntity.getId(),
                    studentEntity.getBatch(),
                    studentEntity.getFirstName(),
                    studentEntity.getInstitute(),
                    studentEntity.getLastName());

    }

    public String retrieveStudentsFirstNameById(String id){

        SqlParameterSource parameters =
                new MapSqlParameterSource().addValue("id",id);

        return namedParameterJdbcTemplate.queryForObject(
                "SELECT first_name FROM student_entity WHERE id = :id",
                parameters, String.class);

    }


    public List<String> retrieveStudentsFirstNamesByBatch(String batchId){

        SqlParameterSource parameters =
                new MapSqlParameterSource().addValue("batchId",batchId);

        return namedParameterJdbcTemplate.queryForList(
                "SELECT first_name FROM student_entity WHERE batch = :batchId",
                parameters, String.class);
    }


    public List<String> retrieveStudentsFirstNamesByBatchAndIns(String batchId,
                                                                String institute){

        SqlParameterSource parameters =
                new MapSqlParameterSource()
                        .addValue("batchId",batchId)
                        .addValue("institute",institute);

        return namedParameterJdbcTemplate.queryForList(
                "SELECT first_name FROM student_entity WHERE batch = :batchId\n" +
                        "and institute= :institute;",
                parameters, String.class);
    }



    public void addStudentV2(StudentEntity studentEntity){

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("first_name",studentEntity.getFirstName());
        parameters.put("last_name",studentEntity.getLastName());
        parameters.put("batch",studentEntity.getBatch());


        new SimpleJdbcInsert(dataSource)
                .withTableName("student_entity")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(parameters);
    }


    public boolean updateBatchStudentWise(String batchId,String firstName){

        SqlParameterSource parameters =
                new MapSqlParameterSource()
                        .addValue("batchId",batchId)
                        .addValue("firstName",firstName);

        int update = namedParameterJdbcTemplate.update(
                "UPDATE student_entity set batch =:batch where first_name = :firstName",
                parameters);

        return update > 0;
    }



}