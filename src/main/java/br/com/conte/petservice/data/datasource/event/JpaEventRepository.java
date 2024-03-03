package br.com.conte.petservice.data.datasource.event;

import br.com.conte.petservice.data.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findAllByPetEntityId(Long petId);
}
