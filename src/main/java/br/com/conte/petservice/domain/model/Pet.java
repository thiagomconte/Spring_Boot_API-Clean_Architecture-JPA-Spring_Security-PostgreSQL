package br.com.conte.petservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pet {
  private Long id;
  private String name;
  private String breed;
  private Gender gender;

  public enum Gender {
    MALE, FEMALE;
  }
}
