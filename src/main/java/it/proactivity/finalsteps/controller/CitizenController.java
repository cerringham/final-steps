package it.proactivity.finalsteps.controller;

import it.proactivity.finalsteps.model.dto.CitizenDto;
import it.proactivity.finalsteps.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/get-all-citizens")
    public ResponseEntity<List<CitizenDto>> getAll() {
        return citizenService.getAll();
    }
}
