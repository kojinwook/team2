package com.example.back.controller;


import com.example.back.dto.request.auth.SignUpRequestDto;
import com.example.back.dto.response.auth.SignUpResponseDto;
import com.example.back.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

  @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody){
      ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
      return response;
  }



}
