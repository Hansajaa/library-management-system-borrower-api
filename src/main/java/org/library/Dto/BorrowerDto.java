package org.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String contactNumber;
}
