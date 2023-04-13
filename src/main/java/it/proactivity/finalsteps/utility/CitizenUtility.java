package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.builder.CitizenBuilder;
import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.repository.CitizenRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class CitizenUtility {

    @Autowired
    CitizenRepository citizenRepository;

    public List<CitizenDto> generateDtoList(List<Citizen> citizens) {
        return citizens.stream()
                .map(c -> new CitizenDto(c.getId(), c.getName(), c.getSurname(), c.getBirthdate(), c.getFiscalCode(),
                        c.getAddress(), c.getIdNumber()))
                .toList();
    }

    public Boolean citizenDtoIsValid(CitizenDto citizenDto) {
        return citizenDto != null && !citizenAlreadyExists(citizenDto.getFiscalCode()) && StringUtils.isAlpha(citizenDto.getName()) && StringUtils.isAlpha(citizenDto.getSurname()) &&
                citizenDto.getBirthdate().isBefore(LocalDate.now()) && StringUtils.isAlphanumeric(citizenDto.getFiscalCode())
                && StringUtils.isAlphanumericSpace(citizenDto.getAddress()) && StringUtils.isAlphanumeric(citizenDto.getIdNumber());
    }

    public Boolean dtoForUpdateIsValid(CitizenDto citizenDto) {
        return citizenDto != null && StringUtils.isAlpha(citizenDto.getName()) && StringUtils.isAlpha(citizenDto.getSurname()) &&
                StringUtils.isAlphanumericSpace(citizenDto.getAddress());
    }
    public Long getCitizenId() {
        Optional<Long> newId = citizenRepository.findNextId();
        return newId.orElse(1l);
    }

    public Boolean citizenAlreadyExists(String fiscalCode) {
        Optional<Citizen> citizen = citizenRepository.findByFiscalCode(fiscalCode);
        return citizen.isPresent();
    }
    public Citizen createCitizenFromDto(CitizenDto citizenDto) {
        return CitizenBuilder.newBuilder(getCitizenId())
                .name(citizenDto.getName())
                .surname(citizenDto.getSurname())
                .birthdate(citizenDto.getBirthdate())
                .fiscalCode(citizenDto.getFiscalCode())
                .address(citizenDto.getAddress())
                .idNumber(citizenDto.getIdNumber())
                .build();
    }

    public void updateCitizenFromDto(CitizenDto citizenDto, Citizen citizen) {
        citizen.setName(citizenDto.getName());
        citizen.setSurname(citizenDto.getSurname());
        citizen.setAddress(citizenDto.getAddress());
    }
}
