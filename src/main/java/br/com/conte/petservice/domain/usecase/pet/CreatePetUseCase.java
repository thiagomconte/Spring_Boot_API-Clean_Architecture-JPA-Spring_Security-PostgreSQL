package br.com.conte.petservice.domain.usecase.pet;

import br.com.conte.petservice.domain.model.Pet;
import br.com.conte.petservice.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class CreatePetUseCase {

    private final PetRepository repository;

    public void execute(Pet pet) {
        repository.createPet(pet);
    }
}
