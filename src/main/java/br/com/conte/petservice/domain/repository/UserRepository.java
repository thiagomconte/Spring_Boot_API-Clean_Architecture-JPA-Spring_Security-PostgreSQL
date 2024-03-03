package br.com.conte.petservice.domain.repository;

import br.com.conte.petservice.domain.model.User;

public interface UserRepository {

    void createUser(User user);
}
