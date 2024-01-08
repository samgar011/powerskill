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
public class UserRequestUpdateDto {
    private String email;
    private String userName;
    private String password;
    private String bio;
    private Long contactNumber;
}
