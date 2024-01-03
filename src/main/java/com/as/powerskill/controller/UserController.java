package com.as.powerskill.controller;

import com.as.powerskill.dto.request.UserRequestDto;
import com.as.powerskill.dto.response.BooleanResponse;
import com.as.powerskill.dto.response.UserDetailResponsetDto;
import com.as.powerskill.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Abdurrahman Samgar
 */


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public BooleanResponse createUser(@RequestBody UserRequestDto userRequestDto, Integer suffix) {
        userService.createUser(userRequestDto, suffix);
        return BooleanResponse.success();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetailResponsetDto>> getAllUsers() {
        List<UserDetailResponsetDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping
    public BooleanResponse updateUser(@RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(userRequestDto);
        return BooleanResponse.success();
    }
}
