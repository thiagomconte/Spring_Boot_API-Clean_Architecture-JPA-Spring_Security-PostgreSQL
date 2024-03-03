package br.com.conte.petservice.data.datasource.event.impl;

import br.com.conte.petservice.data.datasource.event.EventLocalDataSource;
import br.com.conte.petservice.data.datasource.event.JpaEventRepository;
import br.com.conte.petservice.data.entity.EventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
public class EventLocalDataSourceImpl implements EventLocalDataSource {

    private final JpaEventRepository repository;

    @Override
    public void createEvent(EventEntity eventEntity) {
        repository.save(eventEntity);
    }

    @Override
    public List<EventEntity> getAllByPetId(Long petId) {
        return repository.findAllByPetEntityId(petId);
    }
}
