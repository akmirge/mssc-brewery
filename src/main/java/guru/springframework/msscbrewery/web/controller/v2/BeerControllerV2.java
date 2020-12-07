package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID id) {
        return new ResponseEntity<>(this.beerService.getBeerById(id), HttpStatus.OK);
    }

    @PostMapping // This automatically handles Create new Beer
    public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDto beer) {
        BeerDtoV2 savedBeer = this.beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to Url
        headers.add("Location",
                "/api/v2/beer/" + savedBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<HttpStatus> handleUpdate(@PathVariable("beerId") UUID id, @RequestBody BeerDto beer) {
        this.beerService.updateBeer(id, beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID id) {
        this.beerService.deleteBeer(id);
    }

}
