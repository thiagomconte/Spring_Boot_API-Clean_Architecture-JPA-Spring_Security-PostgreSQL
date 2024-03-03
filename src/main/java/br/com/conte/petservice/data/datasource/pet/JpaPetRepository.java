package br.com.conte.petservice.data.datasource.pet;

import br.com.conte.petservice.data.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPetRepository extends JpaRepository<PetEntity, Long> {
}
