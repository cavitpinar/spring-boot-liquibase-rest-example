package com.magnesiatech.liquibasEexample.controller;

import static com.magnesiatech.liquibasEexample.constants.RestApiConstants.API_VERSION_1;
import static com.magnesiatech.liquibasEexample.constants.RestApiConstants.CUSTOMER;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import com.magnesiatech.liquibasEexample.constants.RestApiConstants;
import com.magnesiatech.liquibasEexample.dto.request.CustomerPostRequestDto;
import com.magnesiatech.liquibasEexample.repository.entity.Customer;
import com.magnesiatech.liquibasEexample.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = API_VERSION_1 + "/" + CUSTOMER)
@Slf4j
@Validated
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @ApiOperation(value = "Create Customer", nickname = "createCustomer", response = ResponseEntity.class)
  @PostMapping(value = API_VERSION_1 + "/" + CUSTOMER ,produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> createCustomer(
      @RequestBody @Valid CustomerPostRequestDto customerPostRequestDto) {

    log.info("received a call to create customer");

    Customer customer = Customer.builder()
        .name(customerPostRequestDto.getName())
        .surname(customerPostRequestDto.getSurname()).address(customerPostRequestDto.getAddress())
        .build();

    customerService.createCustomer(customer);
    return ok().build();
  }


}
