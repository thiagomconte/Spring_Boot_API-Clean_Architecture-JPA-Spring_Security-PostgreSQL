package br.com.conte.petservice.domain.usecase.event;

import br.com.conte.petservice.domain.model.Event;
import br.com.conte.petservice.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllEventsByPetIdUseCase {

    private final EventRepository repository;

    public List<Event> execute(Long petId) {
        return repository.getAllEventsByPetId(petId);
    }

}
