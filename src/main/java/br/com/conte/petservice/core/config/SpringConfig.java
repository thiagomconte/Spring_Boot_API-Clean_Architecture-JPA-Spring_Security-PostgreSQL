package br.com.conte.petservice.core.config;

import br.com.conte.petservice.data.datasource.event.EventLocalDataSource;
import br.com.conte.petservice.data.datasource.event.JpaEventRepository;
import br.com.conte.petservice.data.datasource.event.impl.EventLocalDataSourceImpl;
import br.com.conte.petservice.data.datasource.pet.JpaPetRepository;
import br.com.conte.petservice.data.datasource.pet.PetLocalDataSource;
import br.com.conte.petservice.data.datasource.pet.impl.PetLocalDataSourceImpl;
import br.com.conte.petservice.data.datasource.user.JpaUserRepository;
import br.com.conte.petservice.data.datasource.user.UserLocalDataSource;
import br.com.conte.petservice.data.datasource.user.impl.UserLocalDataSourceImpl;
import br.com.conte.petservice.data.repository.EventRepositoryImpl;
import br.com.conte.petservice.data.repository.PetRepositoryImpl;
import br.com.conte.petservice.data.repository.UserRepositoryImpl;
import br.com.conte.petservice.domain.repository.EventRepository;
import br.com.conte.petservice.domain.repository.PetRepository;
import br.com.conte.petservice.domain.repository.UserRepository;
import br.com.conte.petservice.domain.usecase.event.CreateEventUseCase;
import br.com.conte.petservice.domain.usecase.event.GetAllEventsByPetIdUseCase;
import br.com.conte.petservice.domain.usecase.pet.CreatePetUseCase;
import br.com.conte.petservice.domain.usecase.pet.GetAllPetsUseCase;
import br.com.conte.petservice.domain.usecase.pet.GetPetByIdUseCase;
import br.com.conte.petservice.domain.usecase.user.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // PET CONFIG

    @Bean
    public PetLocalDataSource petLocalDataSource(JpaPetRepository jpaPetRepository) {
        return new PetLocalDataSourceImpl(jpaPetRepository);
    }

    @Bean
    public PetRepository petRepository(PetLocalDataSource petLocalDataSource) {
        return new PetRepositoryImpl(petLocalDataSource);
    }

    @Bean
    public CreatePetUseCase createPetUseCase(PetRepository petRepository) {
        return new CreatePetUseCase(petRepository);
    }

    @Bean
    public GetAllPetsUseCase getAllPetsUseCase(PetRepository petRepository) {
        return new GetAllPetsUseCase(petRepository);
    }

    @Bean
    public GetPetByIdUseCase getPetByIdUseCase(PetRepository petRepository) {
        return new GetPetByIdUseCase(petRepository);
    }

    // EVENT CONFIG

    @Bean
    public EventLocalDataSource eventLocalDataSource(JpaEventRepository jpaEventRepository) {
        return new EventLocalDataSourceImpl(jpaEventRepository);
    }

    @Bean
    public EventRepository eventRepository(EventLocalDataSource eventLocalDataSource) {
        return new EventRepositoryImpl(eventLocalDataSource);
    }

    @Bean
    public CreateEventUseCase createEventUseCase(EventRepository eventRepository) {
        return new CreateEventUseCase(eventRepository);
    }

    @Bean
    public GetAllEventsByPetIdUseCase getAllEventsByPetIdUseCase(EventRepository eventRepository) {
        return new GetAllEventsByPetIdUseCase(eventRepository);
    }

    // USER CONFIG

    @Bean
    public UserLocalDataSource userLocalDataSource(JpaUserRepository jpaUserRepository) {
        return new UserLocalDataSourceImpl(jpaUserRepository);
    }

    @Bean
    public UserRepository userRepository(UserLocalDataSource userLocalDataSource) {
        return new UserRepositoryImpl(userLocalDataSource);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }
}
