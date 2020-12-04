package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getById(UUID id) {
        log.info("Get Customer by Id: " + id);
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("John Casey")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
       log.info("Creating a new Customer");
       return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void update(UUID id, CustomerDto customer) {
        log.info("Updating Customer with id: " + id);
        //TODO Implement Customer update
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting Customer with Id: " + id);
        //TODO Implement Customer delete
    }
}
