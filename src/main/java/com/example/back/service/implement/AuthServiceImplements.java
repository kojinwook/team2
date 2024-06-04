package com.example.back.service.implement;


import com.example.back.dto.request.auth.SignUpRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.auth.SignUpResponseDto;
import com.example.back.entity.CertificationEntity;
import com.example.back.entity.UserEntity;
import com.example.back.provider.EmailProvider;
import com.example.back.repository.CertificationRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplements implements AuthService {

    private final UserRepository userRepository;
    private final EmailProvider emailProvider;
    private final CertificationRepository certificationRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try{
            String userId = dto.getUserId();
            boolean isExistId =  userRepository.existsByUserId(userId);
            if(isExistId) return SignUpResponseDto.duplicatedId();

            String email = dto.getEmail();
            boolean isExistedEmail = userRepository.existsByEmail(email);
            if(isExistedEmail) return SignUpResponseDto.duplicatedEmail();

            String nickname = dto.getNickname();
            boolean isExistNickname = userRepository.existsByNickname(nickname);
            if(isExistNickname) return SignUpResponseDto.duplicatedNickname();

            String certificationNumber = dto.getCertificationNumber();
            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);
            boolean isMatched = certificationEntity.getEmail().equals(email) &&
                    certificationEntity.getCertificationNumber().equals(certificationNumber);
            if(!isMatched) return SignUpResponseDto.certificationFail();

            String password = dto.getPassword();
            String encodePassword = passwordEncoder.encode(password);
            dto.setPassword(encodePassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            certificationRepository.deleteByUserId(userId);

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }



}
