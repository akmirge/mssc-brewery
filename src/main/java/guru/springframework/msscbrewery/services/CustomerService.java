package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID id);

    CustomerDto save(CustomerDto customer);

    void update(UUID id, CustomerDto customer);

    void delete(UUID id);
}
