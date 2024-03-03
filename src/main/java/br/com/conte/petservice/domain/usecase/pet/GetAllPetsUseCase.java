package br.com.conte.petservice.domain.usecase.pet;

import br.com.conte.petservice.domain.model.Pet;
import br.com.conte.petservice.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllPetsUseCase {

    private final PetRepository repository;

    public List<Pet> execute() {
        return repository.getAll();
    }
}
