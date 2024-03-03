package br.com.conte.petservice.data.repository;

import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.data.datasource.pet.PetLocalDataSource;
import br.com.conte.petservice.data.mapper.PetMapper;
import br.com.conte.petservice.data.entity.PetEntity;
import br.com.conte.petservice.domain.model.Pet;
import br.com.conte.petservice.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

    private final PetLocalDataSource localDataSource;

    @Override
    public void createPet(Pet pet) {
        localDataSource.createPetModel(PetMapper.toPetEntity(pet));
    }

    @Override
    public List<Pet> getAll() {
        List<PetEntity> pets = localDataSource.getAll();
        return PetMapper.toPetList(pets);
    }

    @Override
    public Pet getById(Long id) throws DatabaseEntityNotFound {
        PetEntity petEntity = localDataSource.getById(id);
        return PetMapper.toPet(petEntity);
    }
}
