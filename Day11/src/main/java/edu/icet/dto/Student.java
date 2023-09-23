package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String batch;
    private String institute;
}
