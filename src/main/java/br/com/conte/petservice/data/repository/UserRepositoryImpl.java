package br.com.conte.petservice.data.repository;

import br.com.conte.petservice.data.datasource.user.UserLocalDataSource;
import br.com.conte.petservice.data.entity.UserEntity;
import br.com.conte.petservice.data.mapper.UserMapper;
import br.com.conte.petservice.domain.model.User;
import br.com.conte.petservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserLocalDataSource localDataSource;

    @Override
    public void createUser(User user) {
        UserEntity userEntity = UserMapper.toUserEntity(user);
        localDataSource.createUser(userEntity);
    }
}
