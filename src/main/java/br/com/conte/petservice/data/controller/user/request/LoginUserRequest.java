package br.com.conte.petservice.data.controller.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUserRequest(
        @NotBlank(message = "E-mail not provided!")
        @Email(message = "Invalid e-mail format!")
        String email,
        @NotBlank(message = "Password not provided!")
        String password
) {
}
