package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.builder.CitizenBuilder;
import it.proactivity.finalsteps.builder.CitizenDTOBuilder;
import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CitizenUtility {

    @Autowired
    ParsingUtility parsingUtility;

    @Autowired
    CitizenRepository citizenRepository;

    public List<CitizenDto> createCitizenDtoList(List<Citizen> citizens) {
        return citizens.stream()
                .map(c -> new CitizenDto(c.getName(), c.getSurname(), parsingUtility.parseLocalDateToString(c.getBirthdate()),
                        c.getFiscalCode(), c.getAddress(), c.getIdNumber()))
                .toList();
    }

    public Optional<CitizenDto> createCitizenDTO(Long id) {
        //find the citizen using id
        Optional<Citizen> citizen = citizenRepository.findById(id);

        //if citizen is empty return an empty citizen object
        if (citizen.isEmpty()) {
            return Optional.empty();
        } else {
            String parsedDate = parsingUtility.parseLocalDateToString(citizen.get().getBirthdate());

            return Optional.of(CitizenDTOBuilder.newBuilder(citizen.get().getName())
                    .surname(citizen.get().getSurname())
                    .birthdate(parsedDate)
                    .fiscalCode(citizen.get().getFiscalCode())
                    .address(citizen.get().getAddress())
                    .idNumber(citizen.get().getIdNumber())
                    .build());
        }

    }

    public Citizen createCitizen(CitizenDto citizenDto) {

        //parsing the citizenDto birthdate
        LocalDate parsedDate = parsingUtility.parseStringToLocalDate(citizenDto.getBirthdate());
        if (parsedDate == null) {
            return null;
        }

        //retrieving last id inserted
        Optional<Long> citizenLastId = citizenRepository.findLastId();

        if (citizenLastId.isEmpty()) {
            return CitizenBuilder.newBuilder(1L)
                    .name(citizenDto.getName())
                    .surname(citizenDto.getSurname())
                    .birthdate(parsedDate)
                    .fiscalCode(citizenDto.getFiscalCode())
                    .address(citizenDto.getAddress())
                    .idNumber(citizenDto.getIdNumber())
                    .build();
        } else {
            return CitizenBuilder.newBuilder(citizenLastId.get() + 1)
                    .name(citizenDto.getName())
                    .surname(citizenDto.getSurname())
                    .birthdate(parsedDate)
                    .fiscalCode(citizenDto.getFiscalCode())
                    .address(citizenDto.getAddress())
                    .idNumber(citizenDto.getIdNumber())
                    .build();
        }


    }
}
