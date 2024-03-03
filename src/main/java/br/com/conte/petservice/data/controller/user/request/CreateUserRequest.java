package br.com.conte.petservice.data.controller.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "E-mail not provided!")
        @Email(message = "Invalid e-mail format!")
        String username,
        @NotBlank(message = "Password not provided!")
        @Size(min = 6, max = 12, message = "Password must have at least 6 characters and max of 12")
        String password
) {
}
