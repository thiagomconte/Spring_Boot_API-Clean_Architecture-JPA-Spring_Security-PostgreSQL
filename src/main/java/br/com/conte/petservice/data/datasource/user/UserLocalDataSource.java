package br.com.conte.petservice.data.datasource.user;

import br.com.conte.petservice.data.entity.UserEntity;

public interface UserLocalDataSource {

    void createUser(UserEntity userEntity);
}
