package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID id) {
        return null;
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDto beer) {
        return null;
    }

    @Override
    public void updateBeer(UUID id, BeerDto beer) {

    }

    @Override
    public void deleteBeer(UUID id) {

    }
}
