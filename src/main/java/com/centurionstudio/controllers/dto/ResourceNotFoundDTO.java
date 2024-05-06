package com.centurionstudio.controllers.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Getter
@Setter
public class ResourceNotFoundDTO {

    private int status = HttpStatus.NOT_FOUND.value();
    private String series = HttpStatus.NOT_FOUND.series().name();
    private String reasonPhrase = HttpStatus.NOT_FOUND.getReasonPhrase();
    private String path;
    private String message;

    public static <T> ResponseEntity<?> build(Class<T> clazz) {
        ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
        ResourceNotFoundDTO response = new ResourceNotFoundDTO();
        response.setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
