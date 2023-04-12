package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.model.dto.CityDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CityValidator {

    private static final Integer CITY_NAME_MAX_LENGTH = 50;

    public Boolean validateAllParametersForCityDto(CityDto cityDto) {
        if (cityDto == null) {
            return false;
        }
        return cityNameIsAlphaAndNotNull(cityDto.getCityName()) && pinCodeIsNotNullAndInteger(cityDto.getCityPinCode());
    }

    private Boolean cityNameIsAlphaAndNotNull(String cityName) {
        //control if cityName is null or empty
        if (StringUtils.isEmpty(cityName)) {
            return false;
        }
        //return true if city name is alpha space and length less than 50
        return StringUtils.isAlphaSpace(cityName) && cityName.length() <= CITY_NAME_MAX_LENGTH;
    }

    private Boolean pinCodeIsNotNullAndInteger(Integer pinCode) {
        return pinCode != null;
    }
}
