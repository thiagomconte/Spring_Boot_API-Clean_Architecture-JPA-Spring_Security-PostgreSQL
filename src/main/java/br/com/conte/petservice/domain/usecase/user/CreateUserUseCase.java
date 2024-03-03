package br.com.conte.petservice.domain.usecase.user;

import br.com.conte.petservice.domain.model.User;
import br.com.conte.petservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository repository;

    public void execute(User user) {
        repository.createUser(user);
    }
}
