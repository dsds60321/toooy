package dev.gunho.toooy.user.controller;

import dev.gunho.toooy.global.dto.ApiResponse;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Description("로그인")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp() {
        return ApiResponse.SERVER_ERROR();
    }

 }
