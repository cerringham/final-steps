package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.repository.CitizenRepository;
import it.proactivity.finalsteps.utility.CitizenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    CitizenUtility citizenUtility;

    public ResponseEntity<List<CitizenDto>> getAll() {
        List<Citizen> citizens = citizenRepository.findAll();
        List<CitizenDto> dtoList = citizenUtility.generateDtoList(citizens);
        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity addCitizen(CitizenDto citizenDto) {
        if (citizenUtility.citizenDtoIsValid(citizenDto)) {
            Citizen citizen = citizenUtility.createCitizenFromDto(citizenDto);
            citizenRepository.save(citizen);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    public ResponseEntity deleteCitizen(Long id) {
        Optional<Citizen> citizen = citizenRepository.findById(id);
        if (citizen.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        citizenRepository.delete(citizen.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    public ResponseEntity updateCitizen(CitizenDto citizenDto) {
        Optional<Citizen> citizen = citizenRepository.findById(citizenDto.getId());
        if (citizen.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (citizenUtility.dtoForUpdateIsValid(citizenDto)) {
            citizenUtility.updateCitizenFromDto(citizenDto, citizen.get());
            citizenRepository.save(citizen.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
