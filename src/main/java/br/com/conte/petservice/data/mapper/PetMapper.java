package br.com.conte.petservice.data.mapper;

import br.com.conte.petservice.data.entity.PetEntity;
import br.com.conte.petservice.domain.model.Pet;

import java.util.List;
import java.util.stream.Collectors;

public class PetMapper {

    public static PetEntity toPetEntity(Pet pet) {
        return new PetEntity(pet.getName(), pet.getBreed(), pet.getGender());
    }

    public static Pet toPet(PetEntity petEntity) {
        return Pet.builder()
                .id(petEntity.getId())
                .name(petEntity.getName())
                .breed(petEntity.getBreed())
                .gender(petEntity.getGender())
                .build();
    }

    public static List<Pet> toPetList(List<PetEntity> pets) {
        return pets.stream().map(
                PetMapper::toPet
        ).collect(Collectors.toList());
    }
}
