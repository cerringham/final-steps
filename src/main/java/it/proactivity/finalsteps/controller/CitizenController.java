package it.proactivity.finalsteps.controller;

import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;


    @GetMapping("/get-all-citizen")
    public ResponseEntity<List<CitizenDto>> getAll() {
        return citizenService.getAll();
    }

    @GetMapping("/get-citizen/{id}")
    public ResponseEntity<CitizenDto> getById(@PathVariable Long id) {
        return citizenService.getById(id);
    }

    @GetMapping("/delete-citizen/{id}")
    public ResponseEntity deleteCitizenById(@PathVariable Long id) {
        return citizenService.deleteCitizenById(id);
    }

    @PostMapping("insert-citizen")
    public ResponseEntity insertCitizen(@RequestBody CitizenDto citizenDto) {
        return citizenService.insertCitizen(citizenDto);
    }
}
