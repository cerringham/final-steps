package it.proactivity.finalsteps;

import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.repository.CityRepository;
import it.proactivity.finalsteps.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class CityServiceTest {

    private static final HttpStatus OK = HttpStatus.OK;

    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @Autowired
    CityService cityService;


    @Test
    void insertCityPositiveTest() {

        CityDto cityDto = new CityDto("Milano", 87625);

        ResponseEntity insertCityResponse = cityService.insertCity(cityDto);

        HttpStatusCode expected = OK;
        HttpStatusCode actual = insertCityResponse.getStatusCode();

        assertEquals(expected, actual);
    }

    @Test
    void insertCityWithCityDtoNullNegativeTest() {


        ResponseEntity insertCityResponse = cityService.insertCity(null);

        HttpStatusCode expected = BAD_REQUEST;
        HttpStatusCode actual = insertCityResponse.getStatusCode();

        assertEquals(expected, actual);
    }

    @Test
    void insertCityWithCityNameNullNegativeTest() {

        CityDto cityDto = new CityDto(null, 87625);

        ResponseEntity insertCityResponse = cityService.insertCity(cityDto);

        HttpStatusCode expected = BAD_REQUEST;
        HttpStatusCode actual = insertCityResponse.getStatusCode();

        assertEquals(expected, actual);
    }

    @Test
    void insertCityWithCityNameEmptyNegativeTest() {

        CityDto cityDto = new CityDto("", 87625);

        ResponseEntity insertCityResponse = cityService.insertCity(cityDto);

        HttpStatusCode expected = BAD_REQUEST;
        HttpStatusCode actual = insertCityResponse.getStatusCode();

        assertEquals(expected, actual);
    }

    @Test
    void insertCityWithCityPinCodeNullNegativeTest() {

        CityDto cityDto = new CityDto("Milano", null);

        ResponseEntity insertCityResponse = cityService.insertCity(cityDto);

        HttpStatusCode expected = BAD_REQUEST;
        HttpStatusCode actual = insertCityResponse.getStatusCode();

        assertEquals(expected, actual);
    }

    @Test
    void getAllPositiveTest() {
        ResponseEntity<List<CityDto>> cityDtoList = cityService.getAll();

        HttpStatusCode expected = OK;
        HttpStatusCode actual = cityDtoList.getStatusCode();

        assertEquals(expected, actual);

    }


}

