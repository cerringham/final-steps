package it.proactivity.finalsteps;

import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.service.CitizenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CitizenServiceTest {

    @Autowired
    CitizenService citizenService;

    @Test
    void getAllCitizensTest() {
        ResponseEntity<List<CitizenDto>> response = citizenService.getAll();

        assertTrue(response.getBody() != null);
    }

    @Test
    void addCitizenPositiveTest() {
        CitizenDto citizenDto = new CitizenDto("Veronica" , "Zuniga", LocalDate.of(2000, 06, 22),
                "TRJGU4768IYJTG4", "via roma 5", "ATU75489I");
        ResponseEntity response = citizenService.addCitizen(citizenDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void addCitizenAlreadyExistingCitizenTest() {
        CitizenDto citizenDto = new CitizenDto("Veronica" , "Zuniga", LocalDate.of(2000, 06, 22),
                "TRJGU4768IYJTG4", "via roma 5", "ATU75489I");
        ResponseEntity response = citizenService.addCitizen(citizenDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
