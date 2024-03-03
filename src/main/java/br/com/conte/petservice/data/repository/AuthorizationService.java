package br.com.conte.petservice.data.repository;

import br.com.conte.petservice.core.security.TokenService;
import br.com.conte.petservice.data.controller.user.request.CreateUserRequest;
import br.com.conte.petservice.data.controller.user.request.LoginUserRequest;
import br.com.conte.petservice.data.datasource.user.JpaUserRepository;
import br.com.conte.petservice.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    public String login(LoginUserRequest loginUserRequest) {
        AuthenticationManager authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(loginUserRequest.email(), loginUserRequest.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((UserEntity) auth.getPrincipal());
    }
}