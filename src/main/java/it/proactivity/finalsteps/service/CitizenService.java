package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDTO;
import it.proactivity.finalsteps.repository.CitizenRepository;
import it.proactivity.finalsteps.utility.CitizenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    CitizenUtility citizenUtility;
    public ResponseEntity<List<CitizenDTO>> getAll() {
        List<Citizen> citizens = citizenRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(citizenUtility.createCitizenDtoList(citizens));
    }
}
