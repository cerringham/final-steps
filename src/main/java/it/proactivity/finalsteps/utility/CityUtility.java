package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.model.City;
import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityUtility {
    @Autowired
    CityRepository cityRepository;

    public Long getNextCityId() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().count() + 1l;
    }

    public Boolean cityDtoIsValid(CityDto cityDto) {
        if (cityDto == null || !StringUtils.isAlpha(cityDto.getCityName()) || cityAlreadyExists(cityDto.getCityName())
                || cityDto.getCityPinCode() == null) {
            return false;
        }
        return true;
    }

    public Boolean cityAlreadyExists(String cityName) {
        Optional<City> city = cityRepository.findByCityName(cityName);
        if (city.isPresent()) {
            return true;
        }
        return false;
    }
}
