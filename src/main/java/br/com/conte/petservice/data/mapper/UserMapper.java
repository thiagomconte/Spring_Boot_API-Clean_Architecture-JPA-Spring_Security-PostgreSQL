package br.com.conte.petservice.data.mapper;

import br.com.conte.petservice.data.controller.user.request.CreateUserRequest;
import br.com.conte.petservice.data.entity.UserEntity;
import br.com.conte.petservice.domain.model.User;

public class UserMapper {

    public static UserEntity toUserEntity(User user) {
        return new UserEntity(user.getUsername(), user.getPassword());
    }

    public static User toUser(CreateUserRequest createUserRequest) {
        return User.builder().username(createUserRequest.email()).password(createUserRequest.password()).build();
    }
}
