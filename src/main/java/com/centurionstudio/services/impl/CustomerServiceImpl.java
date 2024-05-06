package com.centurionstudio.services.impl;

import com.centurionstudio.entities.CustomerEntity;
import com.centurionstudio.repositories.CustomerRepository;
import com.centurionstudio.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Page<CustomerEntity> searchPaged() {
        return customerRepository.findAll(Pageable.unpaged());
    }

    @Override
    public List<CustomerEntity> searchList() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<CustomerEntity> read(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> update(Long id, CustomerEntity customer) {
        return customerRepository.findById(id).map(customer1 -> {
            map(customer1, customer);
            return Optional.of(customerRepository.save(customer1));
        }).orElse(Optional.empty());
    }

    @Override
    public void delete(Long id) {

    }


    private void map(CustomerEntity from, CustomerEntity to) {
        to.setFirstName(from.getFirstName());
        to.setMiddleName(from.getMiddleName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setPhone(from.getPhone());
    }
}
