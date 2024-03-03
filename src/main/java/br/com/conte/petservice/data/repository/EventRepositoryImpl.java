package br.com.conte.petservice.data.repository;

import br.com.conte.petservice.data.datasource.event.EventLocalDataSource;
import br.com.conte.petservice.data.entity.EventEntity;
import br.com.conte.petservice.data.mapper.EventMapper;
import br.com.conte.petservice.domain.model.Event;
import br.com.conte.petservice.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {

    private final EventLocalDataSource localDataSource;

    @Override
    public void createEvent(Event event) {
        localDataSource.createEvent(EventMapper.toEntity(event));
    }

    @Override
    public List<Event> getAllEventsByPetId(Long petId) {
        List<EventEntity> events = localDataSource.getAllByPetId(petId);
        return EventMapper.toListEvent(events);
    }
}
