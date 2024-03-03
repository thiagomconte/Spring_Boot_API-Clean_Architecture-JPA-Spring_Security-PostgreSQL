package br.com.conte.petservice.data.datasource.event;

import br.com.conte.petservice.data.entity.EventEntity;

import java.util.List;

public interface EventLocalDataSource {

    void createEvent(EventEntity eventEntity);

    List<EventEntity> getAllByPetId(Long petId);
}
