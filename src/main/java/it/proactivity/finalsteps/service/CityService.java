package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.City;
import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public ResponseEntity<List<CityDto>> getAll() {
        List<City> cities = cityRepository.findAll();

        List<CityDto> dtoList = cities.stream()
                .map(c -> new CityDto(c.getId(), c.getCityName(), c.getCityPincode()))
                .toList();

        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity<Boolean> addCity(CityDto city) {
        City myCity = new City(1L, city.getCityName(), city.getCityPincode());
        if(cityRepository.save(myCity) != null)
            return ResponseEntity.ok(Boolean.TRUE);
        else
            return ResponseEntity.ok(Boolean.FALSE);
    }
}
