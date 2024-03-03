package br.com.conte.petservice.domain.usecase.event;

import br.com.conte.petservice.domain.model.Event;
import br.com.conte.petservice.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateEventUseCase {

    private final EventRepository eventRepository;

    public void execute(Event event) {
        eventRepository.createEvent(event);
    }
}
