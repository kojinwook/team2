package com.example.back.dto.request.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SingInResponseDto {
    @NotBlank
    private String userId;

    @NotBlank
    private String password;



}
