package br.com.conte.petservice.data.mapper;

import br.com.conte.petservice.data.controller.event.request.CreateEventRequest;
import br.com.conte.petservice.data.entity.EventEntity;
import br.com.conte.petservice.domain.model.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class EventMapper {

    public static EventEntity toEntity(Event event) {
        return new EventEntity(event.getName(), event.getEventDate(), event.getPetId());
    }

    public static Event toEvent(CreateEventRequest event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime eventDate = LocalDateTime.parse(event.eventDate(), formatter);
        return Event.builder().name(event.name()).eventDate(eventDate).petId(event.petId()).build();
    }

    public static Event toEvent(EventEntity eventEntity) {
        return Event.builder().id(eventEntity.getId()).name(eventEntity.getName()).eventDate(eventEntity.getEventDate()).petId(eventEntity.getPetEntity().getId()).build();
    }

    public static List<Event> toListEvent(List<EventEntity> eventEntities) {
        return eventEntities.stream().map(
                EventMapper::toEvent
        ).collect(Collectors.toList());
    }
}
