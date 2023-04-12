package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.builder.CityBuilder;
import it.proactivity.finalsteps.model.City;
import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import it.proactivity.finalsteps.utility.CityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityUtility cityUtility;

    public ResponseEntity<List<CityDto>> getAll() {
        List<City> cities = cityRepository.findAll();

        List<CityDto> dtoList = cities.stream()
                .map(c -> new CityDto(c.getId(), c.getCityName(), c.getCityPinCode()))
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity addCity(CityDto cityDto) {
       if (cityUtility.cityDtoIsValid(cityDto)) {
           City city = CityBuilder.newBuilder(cityUtility.getNextCityId())
                   .cityName(cityDto.getCityName())
                   .cityPinCode(cityDto.getCityPinCode())
                   .build();
           cityRepository.save(city);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
