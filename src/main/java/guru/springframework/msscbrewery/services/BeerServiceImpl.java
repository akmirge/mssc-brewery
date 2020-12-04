package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {
        log.info("Get the Beer with id: " + id);
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        log.info("Creating a new Beer");
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beer) {
        //TODO:: Need to implement
        log.info("Updating Beer with Id: " + id);
    }

    @Override
    public void deleteBeer(UUID id) {
        log.info("Deleting Beer by Id: " + id);
    }
}
