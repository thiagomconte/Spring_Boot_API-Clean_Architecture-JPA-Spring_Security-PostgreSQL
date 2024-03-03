package br.com.conte.petservice.data.datasource.pet.impl;

import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.data.datasource.pet.JpaPetRepository;
import br.com.conte.petservice.data.datasource.pet.PetLocalDataSource;
import br.com.conte.petservice.data.entity.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetLocalDataSourceImpl implements PetLocalDataSource {

    private final JpaPetRepository petRepository;

    @Override
    public void createPetModel(PetEntity petEntity) {
        petRepository.save(petEntity);
    }

    @Override
    public List<PetEntity> getAll() {
        return petRepository.findAll();
    }

    @Override
    public PetEntity getById(Long id) throws DatabaseEntityNotFound {
        return petRepository.findById(id).orElseThrow(
                () -> new DatabaseEntityNotFound(String.format("Pet id=[%s] not found", id))
        );
    }
}
