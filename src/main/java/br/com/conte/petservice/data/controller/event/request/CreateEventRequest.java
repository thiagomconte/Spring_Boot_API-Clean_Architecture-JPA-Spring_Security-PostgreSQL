package br.com.conte.petservice.data.controller.event.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEventRequest(
        @NotBlank(message = "name is required!")
        String name,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        String eventDate,
        @NotNull(message = "petId is required!")
        Long petId
) {
}
