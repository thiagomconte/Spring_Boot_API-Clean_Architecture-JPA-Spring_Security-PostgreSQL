package br.com.conte.petservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Event {

    private Long id;
    private String name;
    private LocalDateTime eventDate;
    private Long petId;
}
