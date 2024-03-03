package br.com.conte.petservice.data.entity;

import br.com.conte.petservice.domain.model.Pet;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "pets")
@NoArgsConstructor
public class PetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Pet.Gender gender;

    public PetEntity(String name, String breed, Pet.Gender gender) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }

    public PetEntity(Long id) {
        this.id = id;
    }
}
