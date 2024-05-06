package com.centurionstudio.services;


import com.centurionstudio.entities.CustomerEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Page<CustomerEntity> searchPaged();

    List<CustomerEntity> searchList();

    Optional<CustomerEntity> read(Long id);

    CustomerEntity create(CustomerEntity customer);

    Optional<CustomerEntity> update(Long id, CustomerEntity customer);

    void delete(Long id);
}
