package it.proactivity.finalsteps;


import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;


import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class CitizenServiceTest {

    private static final HttpStatus OK = HttpStatus.OK;

    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    @Autowired
    CitizenService citizenService;

    @Test
    void insertCitizenPositiveTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = OK;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithNullDtoNegativeTest() {

        HttpStatusCode actual = citizenService.insertCitizen(null).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithNullNameNegativeTest() {

        CitizenDto citizenDto = new CitizenDto(null, "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithEmptyNameNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithNullSurnameNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", null, "1995-11-16",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithEmptySurnameNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", null, "1995-11-16",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithNullBirthdateNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", null,
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithEmptyBirthdateNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);

    }

    @Test
    void insertCitizenWithBirthdateWrongFormatNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "16-11-1995",
                "csslss95s16d960f", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithnullFiscalCodeNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                null, "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithEmptyFiscalCodeNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithFiscalCodeWrongFormatNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "uuuus873usjd7336", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithFiscalCodeHighLengthNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f0", "via novara 3", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithNullAddressNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", null, "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithEmptyAddressNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "", "xc6789j764");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithNullIdNumberNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 4", null);

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithEmptyIdNumberNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 4", "");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void insertCitizenWithIdNumberHighLengthNegativeTest() {

        CitizenDto citizenDto = new CitizenDto("Alessio", "Cassarino", "1995-11-16",
                "csslss95s16d960f", "via novara 4", "jshdgxbc76ehdjs");

        HttpStatusCode actual = citizenService.insertCitizen(citizenDto).getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;

        assertEquals(expected, actual);
    }

    @Test
    void getAllCitizenPositiveTest() {

        ResponseEntity<List<CitizenDto>> getAllResponse = citizenService.getAll();

        HttpStatusCode actual = getAllResponse.getStatusCode();
        HttpStatusCode expected = OK;
        assertEquals(expected, actual);
    }

    @Test
    void getCitizenByIdCitizenNotFoundNegativeTest() {

        ResponseEntity<CitizenDto> getAllResponse = citizenService.getById(100L);

        HttpStatusCode actual = getAllResponse.getStatusCode();
        HttpStatusCode expected = NOT_FOUND;
        assertEquals(expected, actual);
    }

    @Test
    void getCitizenByIdNullNegativeTest() {

        ResponseEntity<CitizenDto> getAllResponse = citizenService.getById(null);

        HttpStatusCode actual = getAllResponse.getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;
        assertEquals(expected, actual);
    }

    @Test
    void deleteCitizenByIdNullNegativeTest() {
        ResponseEntity getAllResponse = citizenService.deleteCitizenById(null);

        HttpStatusCode actual = getAllResponse.getStatusCode();
        HttpStatusCode expected = BAD_REQUEST;
        assertEquals(expected, actual);
    }

    @Test
    void deleteCitizenByIdCitizenNotFoundNegativeTest() {
        ResponseEntity getAllResponse = citizenService.deleteCitizenById(100L);

        HttpStatusCode actual = getAllResponse.getStatusCode();
        HttpStatusCode expected = NOT_FOUND;
        assertEquals(expected, actual);
    }
}
