package br.com.conte.petservice.data.controller.user;

import br.com.conte.petservice.data.common.SuccessResponse;
import br.com.conte.petservice.data.controller.user.request.CreateUserRequest;
import br.com.conte.petservice.data.mapper.UserMapper;
import br.com.conte.petservice.domain.model.User;
import br.com.conte.petservice.domain.usecase.user.CreateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping()
    public ResponseEntity<SuccessResponse<Void>> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User user = UserMapper.toUser(createUserRequest);
        createUserUseCase.execute(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("User created successfully!"));
    }
}
