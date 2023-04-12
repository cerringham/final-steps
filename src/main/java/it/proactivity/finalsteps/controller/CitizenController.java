package it.proactivity.finalsteps.controller;

import it.proactivity.finalsteps.model.dto.CitizenDTO;
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

    @GetMapping("/get-all")
    public ResponseEntity<List<CitizenDTO>> getAll() {
        return citizenService.getAll();
    }
}
