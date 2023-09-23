package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student{
    //Create Private Reference Variables for Student.
    private String studentFullName;
    private String studentAddress;
    private String studentEmail;
    private String studentContact;
    private String studentSchool;
    private String studentGrade;
    private String studentImage;
}