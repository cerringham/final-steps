package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitizenUtility {

    @Autowired
    ParsingUtility parsingUtility;

    public List<CitizenDTO> createCitizenDtoList(List<Citizen> citizens) {
        return citizens.stream()
                .map(c -> new CitizenDTO(c.getName(), c.getSurname(), parsingUtility.parseLocalDateToString(c.getBirthdate()),
                        c.getFiscalCode(), c.getAddress(), c.getIdNumber()))
                .toList();
    }
}
