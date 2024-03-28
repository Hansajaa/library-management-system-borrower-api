package org.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String address2;
    private String contactNumber;
}
