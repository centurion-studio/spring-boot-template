package com.centurionstudio.controllers.dto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
