package com.centurionstudio.controllers;

import com.centurionstudio.controllers.dto.ResourceNotFoundDTO;
import com.centurionstudio.controllers.dto.customer.CreateCustomerDTO;
import com.centurionstudio.controllers.dto.customer.ReadCustomerDTO;
import com.centurionstudio.controllers.dto.customer.UpdateCustomerDTO;
import com.centurionstudio.controllers.mappers.CustomerMappers;
import com.centurionstudio.entities.CustomerEntity;
import com.centurionstudio.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
//@ApiResponses({
//        @ApiResponse(responseCode = "200", description = "Successful: Stock(s) found."),
//        @ApiResponse(responseCode = "201", description = "Created: Stock created."),
//        @ApiResponse(responseCode = "202", description = "Accepted: Stock updated."),
//        @ApiResponse(responseCode = "204", description = "No Content: Stock deleted."),
//        @ApiResponse(responseCode = "400", description = "Bad Request: Check input parameter(s) syntax for invalid characters."),
//        @ApiResponse(responseCode = "401", description = "Unauthorized: User is not entitled to retrieve information."),
//        @ApiResponse(responseCode = "404", description = "Not Found: Stock(s) not found."),
//        @ApiResponse(responseCode = "500", description = "Internal Server Error: Backend service is down.")
//})
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMappers customerMappers;

    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", description = "Successful: Stock(s) found.")
    @ApiResponse(responseCode = "500", description = "Internal Server Error: Backend service is down.")
    @ApiResponse(responseCode = "401", description = "Unauthorized: User is not entitled to retrieve information.")
    @ApiResponse(responseCode = "403", description = "Forbidden: User is not entitled to retrieve information.")
    public ResponseEntity<?> searchCustomerPaged() {
        return ResponseEntity.ok(customerService.searchPaged());
    }

    //
//    @GetMapping("/{id}")
//    public ResponseEntity<?> searchCustomerPaged() {
//
//    }
    // TODO: configure properly OpenAPI
    @Operation(tags = {"Customer"}, summary = "Create a new customer", responses = {
            @ApiResponse(responseCode = "201", description = "Created: Customer created."),
            @ApiResponse(responseCode = "400", description = "Bad Request: Check input parameter(s) syntax for invalid characters."),
            @ApiResponse(responseCode = "401", description = "Unauthorized: User is not entitled to retrieve information."),
            @ApiResponse(responseCode = "403", description = "Forbidden: User is not entitled to retrieve information."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Backend service is down.")
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CreateCustomerDTO requestBody) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/customers/{id}").build()
                .expand(customerService.create(customerMappers.map(requestBody)).getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Operation(tags = {"Customer"}, summary = "Read customer details by customer id", responses = {
            @ApiResponse(responseCode = "404", description = "Not Found: Customer not found."),
            @ApiResponse(responseCode = "200", description = "Successful: Customer found.", content = @Content(
                    schema = @Schema(implementation = ReadCustomerDTO.class),
                    mediaType = APPLICATION_JSON_VALUE
            )),
            @ApiResponse(responseCode = "401", description = "Unauthorized: user is not entitled to retrieve information."),
            @ApiResponse(responseCode = "403", description = "Forbidden: user is not entitled to retrieve information."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: something unexpected happened.")
    })
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readCustomer(@PathVariable Long id) {
        Optional<CustomerEntity> optionalCustomer = customerService.read(id);
        if (optionalCustomer.isPresent()) {
            return ResponseEntity.ok(customerMappers.mapCustomerDetails(optionalCustomer.get()));
        }

        return ResourceNotFoundDTO.build(ResourceNotFoundDTO.class);
    }


    @Operation(summary = "Update an existing customer identified by its id")
    @ApiResponse(responseCode = "404", description = "Not Found: Stock(s) not found.")
    @ApiResponse(responseCode = "400", description = "Bad Request: Check input parameter(s) syntax for invalid characters.")
    @ApiResponse(responseCode = "401", description = "Unauthorized: User is not entitled to retrieve information.")
    @ApiResponse(responseCode = "500", description = "Internal Server Error: Backend service is down.")
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody UpdateCustomerDTO requestBody) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete a customer by id")
    @ApiResponse(responseCode = "204", description = "No Content: Stock deleted.")
    @ApiResponse(responseCode = "403", description = "Forbidden: User is not entitled to retrieve information.")
    @ApiResponse(responseCode = "401", description = "Unauthorized: User is not entitled to retrieve information.")
    @ApiResponse(responseCode = "500", description = "Internal Server Error: Backend service is down.")
    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
