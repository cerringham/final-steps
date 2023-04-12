package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.repository.CitizenRepository;
import it.proactivity.finalsteps.utility.CitizenUtility;
import it.proactivity.finalsteps.utility.CitizenValidator;
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

    @Autowired
    CitizenValidator citizenValidator;

    public ResponseEntity<List<CitizenDto>> getAll() {
        List<Citizen> citizens = citizenRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(citizenUtility.createCitizenDtoList(citizens));
    }

    public ResponseEntity<CitizenDto> getById(Long id) {
        if (!citizenValidator.validateId(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Optional<CitizenDto> citizenDto = citizenUtility.createCitizenDTO(id);

        if (citizenDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(citizenDto.get());
    }

    public ResponseEntity deleteCitizenById(Long id) {
        if (!citizenValidator.validateId(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //find citizen to delete
        Optional<Citizen> citizenToDelete = citizenRepository.findById(id);

        if (citizenToDelete.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        citizenRepository.delete(citizenToDelete.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity insertCitizen(CitizenDto citizenDto) {

        //dto validation
        if (!citizenValidator.validateCitizenDto(citizenDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //creating citizen
        Citizen citizenToInsert = citizenUtility.createCitizen(citizenDto);
        if (citizenToInsert == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        citizenRepository.save(citizenToInsert);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
