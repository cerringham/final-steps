package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.builder.CityBuilder;
import it.proactivity.finalsteps.model.City;
import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityUtility {

    public static final long BEGINNING_ID = 1L;
    @Autowired
    CityRepository cityRepository;

    public List<CityDto> createCityDtoList(List<City> cities) {
        return cities.stream()
                .map(c -> new CityDto(c.getId(), c.getCityName(), c.getCityPinCode()))
                .toList();
    }

    public City createCity(CityDto cityDto) {

        //find the last id from database
        Optional<Long> cityHighestId = cityRepository.findLastInsertedCity();

        if (cityHighestId.isPresent()) {

            //create the right id for the new city
            Long idForNewCity = cityHighestId.get() + 1;

            return CityBuilder.newBuilder(idForNewCity)
                    .cityName(cityDto.getCityName())
                    .cityPinCode(cityDto.getCityPinCode())
                    .build();
        } else {

            //if the db is empty initialize new city with id equal to 1
            return CityBuilder.newBuilder(BEGINNING_ID)
                    .cityName(cityDto.getCityName())
                    .cityPinCode(cityDto.getCityPinCode())
                    .build();
        }
    }
}
