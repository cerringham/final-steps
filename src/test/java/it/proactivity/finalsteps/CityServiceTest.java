package it.proactivity.finalsteps;

import it.proactivity.finalsteps.model.dto.CityDto;
import it.proactivity.finalsteps.service.CityService;
import it.proactivity.finalsteps.utility.CityUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CityServiceTest {

    @Autowired
    CityUtility cityUtility;

    @Autowired
    CityService cityService;

    @Test
    void getNextCityIdTest() {
        Long newId = cityUtility.getNextCityId();
        System.out.println(newId);
        assertEquals(1l, newId);
    }

    @Test
    void getAllCitiesTest() {
        ResponseEntity<List<CityDto>> response = cityService.getAll();

        assertTrue(response.getBody() != null);
    }

    @Test
    void addCityPositiveTest() {
        CityDto cityDto = new CityDto("Kanpur", 208001);
        ResponseEntity response = cityService.addCity(cityDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void addCityAlreadyExistingCityTest() {
        CityDto cityDto = new CityDto("Kanpur", 208001);
        ResponseEntity response = cityService.addCity(cityDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
