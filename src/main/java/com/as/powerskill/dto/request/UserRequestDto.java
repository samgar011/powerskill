package com.as.powerskill.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abdurrahman Samgar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String email;
    private String userName;
    private String password;
    private String bio;
    private Long contactNumber;
    private String name;
    private String lastName;
    private String title;
    private String uniqueName;
}
