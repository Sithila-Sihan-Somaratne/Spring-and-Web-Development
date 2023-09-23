package edu.icet.dto.response;

import edu.icet.dto.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class StudentResponse {

    List<Student> studentList;
}
