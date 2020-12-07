package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID id);

    BeerDtoV2 saveNewBeer(BeerDto beer);

    void updateBeer(UUID id, BeerDto beer);

    void deleteBeer(UUID id);
}
