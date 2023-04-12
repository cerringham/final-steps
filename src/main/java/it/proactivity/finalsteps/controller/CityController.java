package it.proactivity.finalsteps.controller;

import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping("/add-city")
    public ResponseEntity addCity(@RequestBody CityDto cityDto) {
        return cityService.addCity(cityDto);
    }

    @GetMapping("/get-all-cities")
    public ResponseEntity<List<CityDto>> getAll() {
        return cityService.getAll();
    }

}
