package br.com.conte.petservice.domain.usecase.pet;

import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.domain.model.Pet;
import br.com.conte.petservice.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPetByIdUseCase {

    private final PetRepository repository;

    public Pet execute(Long id) throws DatabaseEntityNotFound {
        return repository.getById(id);
    }
}
