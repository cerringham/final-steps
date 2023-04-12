package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.City;
import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import it.proactivity.finalsteps.utility.CityUtility;
import it.proactivity.finalsteps.utility.CityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityUtility cityUtility;

    @Autowired
    CityValidator cityValidator;

    public ResponseEntity<List<CityDto>> getAll() {
        List<City> cities = cityRepository.findAll();
        return ResponseEntity.ok(cityUtility.createCityDtoList(cities));
    }

    public ResponseEntity insertCity(CityDto cityDto) {
        //validation for all parameters
        if (!cityValidator.validateAllParametersForCityDto(cityDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //creation of new city
        City cityToInsert = cityUtility.createCity(cityDto);

        //insert the city into database
        cityRepository.save(cityToInsert);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
