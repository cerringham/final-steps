package it.proactivity.finalsteps.service;

import it.proactivity.finalsteps.model.Citizen;
import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;
    public ResponseEntity<List<CitizenDto>> getAll() {
        List<Citizen> citizens = citizenRepository.findAll();

        List<CitizenDto> dtoList = citizens.stream()
                .map(c -> new CitizenDto(c.getId(), c.getName(), c.getSurname(), c.getBirthdate(), c.getFiscalCode(),
                        c.getAddress(), c.getIdNumber()))
                .toList();

        return ResponseEntity.ok(dtoList);
    }
}
