package br.com.conte.petservice.data.datasource.pet;

import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.data.entity.PetEntity;

import java.util.List;

public interface PetLocalDataSource {

    void createPetModel(PetEntity petEntity);

    List<PetEntity> getAll();

    PetEntity getById(Long id) throws DatabaseEntityNotFound;
}
