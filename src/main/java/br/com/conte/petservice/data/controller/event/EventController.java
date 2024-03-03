package br.com.conte.petservice.data.controller.event;

import br.com.conte.petservice.data.common.SuccessResponse;
import br.com.conte.petservice.data.controller.event.request.CreateEventRequest;
import br.com.conte.petservice.data.mapper.EventMapper;
import br.com.conte.petservice.domain.model.Event;
import br.com.conte.petservice.domain.usecase.event.CreateEventUseCase;
import br.com.conte.petservice.domain.usecase.event.GetAllEventsByPetIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/event")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final GetAllEventsByPetIdUseCase getAllEventsByPetIdUseCase;

    @PostMapping()
    public ResponseEntity<SuccessResponse<Void>> createEvent(@RequestBody @Valid CreateEventRequest createEventRequest) {
        Event event = EventMapper.toEvent(createEventRequest);
        createEventUseCase.execute(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Event created successfully"));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<SuccessResponse<List<Event>>> getAll(@PathVariable("petId") Long petId) {
        List<Event> events = getAllEventsByPetIdUseCase.execute(petId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(events));
    }
}
