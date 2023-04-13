package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.builder.CityBuilder;
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

    public List<CityDto> generateDtoList(List<City> cities) {
        return cities.stream()
                .map(c -> new CityDto(c.getId(), c.getCityName(), c.getCityPinCode()))
                .toList();
    }

    public City createCityFromDto(CityDto cityDto) {
        return CityBuilder.newBuilder(getCityId())
                .cityName(cityDto.getCityName())
                .cityPinCode(cityDto.getCityPinCode())
                .build();
    }
    public Long getCityId() {
        Optional<Long> newId = cityRepository.findNextId();
        return newId.orElse(1l);
    }

    public Boolean cityDtoIsValid(CityDto cityDto) {
        return cityDto != null && StringUtils.isAlpha(cityDto.getCityName()) && !cityAlreadyExists(cityDto.getCityName())
                && cityDto.getCityPinCode() != null;
    }

    public Boolean cityAlreadyExists(String cityName) {
        Optional<City> city = cityRepository.findByCityName(cityName);
        return city.isPresent();
    }
}
