package com.repair.repair.controller;

import com.repair.repair.dto.request.UserDeleteRequestDto;
import com.repair.repair.dto.request.UserLoginRequestDto;
import com.repair.repair.dto.request.UserMailRequestDto;
import com.repair.repair.dto.request.UserPasswordChangeRequestDto;
import com.repair.repair.dto.request.UserSignupRequestDto;
import com.repair.repair.dto.request.UserUpdateRequestDto;
import com.repair.repair.dto.response.UserDeleteResponseDto;
import com.repair.repair.dto.response.UserLoginResponseDto;
import com.repair.repair.dto.response.UserMailResponseDto;
import com.repair.repair.dto.response.UserPasswordChangeResponseDto;
import com.repair.repair.dto.response.UserSignupResponseDto;
import com.repair.repair.dto.response.UserUpdateResponseDto;
import com.repair.repair.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public UserSignupResponseDto signUp(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        return userService.signUp(userSignupRequestDto);
    }

    @PostMapping("/login")
    public Optional<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

    @PostMapping("passwordchange")
    public Optional<UserPasswordChangeResponseDto> passwordChange(@RequestBody UserPasswordChangeRequestDto userPasswordChangeRequestDto) {
        return userService.passwordUpdate(userPasswordChangeRequestDto);
    }

    @PostMapping("/update")
    public Optional<UserUpdateResponseDto> update(@RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        return userService.updateUser(userUpdateRequestDto);
    }

    @PostMapping("/mail")
    public Optional<UserMailResponseDto> mail(@RequestBody UserMailRequestDto userMailRequestDto) {
        return userService.sendMail(userMailRequestDto);
    }

    @DeleteMapping("/delete")
    public Optional<UserDeleteResponseDto> userDelete(@RequestBody UserDeleteRequestDto userDeleteRequestDto) {
        return userService.deleteUser(userDeleteRequestDto);
    }
}
