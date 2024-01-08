package com.as.powerskill.model;

import com.as.powerskill.model.entity.EntityConstanUtil;
import com.as.powerskill.model.entity.enums.Title;
import com.as.powerskill.model.entity.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;


@Getter
@Setter
@Entity
@Table(name = EntityConstanUtil.PREFIX_TB + "user")
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    protected Long id;

    @CreationTimestamp
    @Column(name = "created_date")
    protected ZonedDateTime createdDate;

    @CreationTimestamp
    @Column(name = "last_modified_date")
    protected ZonedDateTime lastModifiedDate;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "last_modified_by")
    protected String lastModifiedBy;

    @Email
    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Title title;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "unique_user_name", unique = true)
    private String uniqueUserName;

}
