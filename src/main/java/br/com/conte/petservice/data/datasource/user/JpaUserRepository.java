package br.com.conte.petservice.data.datasource.user;

import br.com.conte.petservice.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByEmail(String email);
}
