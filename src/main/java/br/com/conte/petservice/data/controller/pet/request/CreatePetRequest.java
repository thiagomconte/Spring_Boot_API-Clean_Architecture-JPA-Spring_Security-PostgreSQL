package br.com.conte.petservice.data.controller.pet.request;

import br.com.conte.petservice.domain.model.Pet;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public record CreatePetRequest(
        @NotBlank(message = "name is required!")
        String name,
        @NotBlank(message = "breed is required!")
        String breed,
        @NotBlank(message = "gender is required!")
        String gender) {

    public Pet toPet() {
        return Pet.builder()
                .name(name())
                .breed(breed())
                .gender(Pet.Gender.valueOf(gender()))
                .build();
    }
}
