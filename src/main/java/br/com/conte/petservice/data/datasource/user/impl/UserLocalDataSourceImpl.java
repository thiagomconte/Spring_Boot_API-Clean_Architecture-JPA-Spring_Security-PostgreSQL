package br.com.conte.petservice.data.datasource.user.impl;

import br.com.conte.petservice.data.datasource.user.JpaUserRepository;
import br.com.conte.petservice.data.datasource.user.UserLocalDataSource;
import br.com.conte.petservice.data.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserLocalDataSourceImpl implements UserLocalDataSource {

    private final JpaUserRepository userRepository;

    @Override
    public void createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
