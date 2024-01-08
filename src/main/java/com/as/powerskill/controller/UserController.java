package com.as.powerskill.controller;

import com.as.powerskill.dto.request.UserRequestDto;
import com.as.powerskill.dto.request.UserRequestUpdateDto;
import com.as.powerskill.dto.response.BooleanResponse;
import com.as.powerskill.dto.response.UserDetailResponsetDto;
import com.as.powerskill.service.UserService;
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

    private final UserService userService;

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

    @PutMapping("/{id}")
    public BooleanResponse update(
            @PathVariable(value = "id") Long id,
            @RequestBody UserRequestUpdateDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return BooleanResponse.success();
    }


}
