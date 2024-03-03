package br.com.conte.petservice.data.controller.pet;

import br.com.conte.petservice.core.exception.DatabaseEntityNotFound;
import br.com.conte.petservice.data.common.SuccessResponse;
import br.com.conte.petservice.data.controller.pet.request.CreatePetRequest;
import br.com.conte.petservice.domain.model.Pet;
import br.com.conte.petservice.domain.usecase.pet.CreatePetUseCase;
import br.com.conte.petservice.domain.usecase.pet.GetAllPetsUseCase;
import br.com.conte.petservice.domain.usecase.pet.GetPetByIdUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pet")
public class PetController {

    private final CreatePetUseCase createPetUseCase;
    private final GetAllPetsUseCase getAllPetsUseCase;
    private final GetPetByIdUseCase getPetByIdUseCase;

    @PostMapping()
    public ResponseEntity<SuccessResponse<Void>> createPet(@RequestBody @Valid CreatePetRequest createPetRequest) {
        Pet pet = createPetRequest.toPet();
        createPetUseCase.execute(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Pet created successfully"));
    }

    @GetMapping()
    public ResponseEntity<SuccessResponse<List<Pet>>> getAll() {
        List<Pet> pets = getAllPetsUseCase.execute();
        return ResponseEntity.ok(new SuccessResponse<>(pets));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Pet>> getById(@PathVariable("id") Long id) throws DatabaseEntityNotFound {
        Pet pet = getPetByIdUseCase.execute(id);
        return ResponseEntity.ok(new SuccessResponse<>(pet));
    }

}
