package org.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String contactNumber;
}
