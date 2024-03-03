package br.com.conte.petservice.domain.repository;


import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.domain.model.Pet;

import java.util.List;

public interface PetRepository {
    void createPet(Pet pet);

    List<Pet> getAll();

    Pet getById(Long id) throws DatabaseEntityNotFound;
}
