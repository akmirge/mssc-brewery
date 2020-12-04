package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID id) {
        return new ResponseEntity<>(this.beerService.getBeerById(id), HttpStatus.OK);
    }

    @PostMapping // This automatically handles Create new Beer
    public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beer) {
        BeerDto savedBeer = this.beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to Url
        headers.add("Location",
                "/api/v1/beer/" + savedBeer.getId().toString());
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
