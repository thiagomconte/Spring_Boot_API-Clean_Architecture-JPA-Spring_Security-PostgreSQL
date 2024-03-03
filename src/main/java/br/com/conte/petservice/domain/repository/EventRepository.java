package br.com.conte.petservice.domain.repository;

import br.com.conte.petservice.domain.model.Event;

import java.util.List;

public interface EventRepository {

    void createEvent(Event event);

    List<Event> getAllEventsByPetId(Long petId);
}
