package br.com.conte.petservice.data.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuccessResponse<T> {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public SuccessResponse(T data) {
        this.data = data;
        this.message = "success";
    }

    public SuccessResponse(String message) {
        this.message = message;
    }
}
