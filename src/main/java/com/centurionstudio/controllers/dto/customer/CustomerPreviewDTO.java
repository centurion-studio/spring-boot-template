package com.centurionstudio.controllers.dto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPreviewDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
