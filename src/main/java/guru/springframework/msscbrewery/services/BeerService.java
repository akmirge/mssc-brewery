package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID id);

    BeerDto saveNewBeer(BeerDto beer);

    void updateBeer(UUID id, BeerDto beer);

    void deleteBeer(UUID id);
}
