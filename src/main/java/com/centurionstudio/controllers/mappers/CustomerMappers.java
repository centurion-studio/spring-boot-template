package com.centurionstudio.controllers.mappers;


import com.centurionstudio.controllers.dto.customer.CreateCustomerDTO;
import com.centurionstudio.controllers.dto.customer.CustomerPreviewDTO;
import com.centurionstudio.controllers.dto.customer.ReadCustomerDTO;
import com.centurionstudio.controllers.dto.customer.UpdateCustomerDTO;
import com.centurionstudio.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMappers {

    ReadCustomerDTO map(CustomerEntity entity);

    CustomerPreviewDTO mapCustomerDetails(CustomerEntity entity);

    CustomerEntity map(CreateCustomerDTO customer);

    CustomerEntity map(UpdateCustomerDTO customer);
}
