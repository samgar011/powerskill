package com.as.powerskill.service;

import com.as.powerskill.dto.request.UserRequestDto;
import com.as.powerskill.dto.request.UserRequestUpdateDto;
import com.as.powerskill.dto.response.UserDetailResponsetDto;
import com.as.powerskill.model.entity.enums.Title;
import com.as.powerskill.model.User;
import com.as.powerskill.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void createUser(UserRequestDto userRequestDto, Integer suffix) {
        createUserWithUniqueName(userRequestDto, 1);
    }

    @NotNull
    private void createUserWithUniqueName(UserRequestDto userRequestDto, int suffix) {
        User user = new User();
        String baseUniqueName = userRequestDto.getName() + "-" + userRequestDto.getLastName();
        String uniqueUserName = (suffix == 1) ? baseUniqueName.toLowerCase() : baseUniqueName.toLowerCase() + "-" + suffix;

        Optional<User> existingUser = userRepository.findByUniqueUserName(uniqueUserName);
        existingUser.ifPresentOrElse(
                u -> createUserWithUniqueName(userRequestDto, suffix + 1),
                () -> {
                    user.setEmail(userRequestDto.getEmail());
                    user.setUserName(userRequestDto.getUserName());
                    user.setPassword(userRequestDto.getPassword());
                    user.setBio(userRequestDto.getBio());
                    user.setContactNumber(userRequestDto.getContactNumber());
                    user.setTitle(Title.valueOf(userRequestDto.getTitle()));
                    user.setName(userRequestDto.getName());
                    user.setLastName(userRequestDto.getLastName());
                    user.setUniqueUserName(uniqueUserName);
                    userRepository.saveAndFlush(user);
                }
        );
    }

    @Transactional(readOnly = true)
    public List<UserDetailResponsetDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDetailResponsetDto(
                        user.getId(),
                        user.getUserName(),
                        user.getEmail(),
                        user.getBio(),
                        user.getName(),
                        user.getLastName(),
                        user.getTitle().toString(),
                        user.getUniqueUserName(),
                        user.getContactNumber()
                ))
                .collect(Collectors.toList());
    }


    public void updateUser(Long id, UserRequestUpdateDto userRequestDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            if (userRequestDto.getEmail() != null) {
                existingUser.setEmail(userRequestDto.getEmail());
            }
            if (userRequestDto.getUserName() != null) {
                existingUser.setUserName(userRequestDto.getUserName());
            }

            if (userRequestDto.getPassword() != null) {
                existingUser.setPassword(userRequestDto.getPassword());
            }
            if (userRequestDto.getBio() != null) {
                existingUser.setBio(userRequestDto.getBio());
            }
            if (userRequestDto.getContactNumber() != null) {
                existingUser.setContactNumber(userRequestDto.getContactNumber());
            }
            userRepository.saveAndFlush(existingUser);
        }
    }

}
