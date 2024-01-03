package com.as.powerskill.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abdurrahman Samgar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponsetDto {
    private Long userId;
    private String email;
    private String userName;
    private String bio;
    private String contactNumber;
    private String name;
    private String lastName;
    private String title;
    private String uniqueName;

    public UserDetailResponsetDto(Long userId, String userName, String email, String bio,
                                  String name, String lastName, String title, String uniqueName, Long contactNumber) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.bio = bio;
        this.name = name;
        this.lastName = lastName;
        this.title = title;
        this.uniqueName = uniqueName;
        this.contactNumber = String.valueOf(contactNumber);
    }
}
