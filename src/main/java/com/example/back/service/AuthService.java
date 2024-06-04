package com.example.back.service;

import com.example.back.dto.request.auth.*;
import com.example.back.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
//    ResponseEntity<? super userIdCheckResponseDto> userIdCheck(userIdCheckResponseDto dto);
//    ResponseEntity<? super NicknameCheckResponseDto> nicknameCheck(NicknameCheckRequestDto dto);
//    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
//    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(checkCertificationResponseDto dto);
   ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
//    ResponseEntity<? super SingInResponseDto> SignIn(SingInRequestDto dto);
}
