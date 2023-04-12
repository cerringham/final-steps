package it.proactivity.finalsteps.builder;

import it.proactivity.finalsteps.model.Citizen;

import java.time.LocalDate;

public class CitizenBuilder {

    private final Long id;

    private String name;

    private String surname;

    private LocalDate birthdate;

    private String fiscalCode;

    private String address;

    private String idNumber;

    private CitizenBuilder(Long id) {
        this.id = id;
    }

    public static CitizenBuilder newBuilder(Long id) {
        return new CitizenBuilder(id);
    }

    public CitizenBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CitizenBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public CitizenBuilder birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public CitizenBuilder fiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
        return this;
    }

    public CitizenBuilder address(String address) {
        this.address = address;
        return this;
    }

    public CitizenBuilder idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public Citizen build() {
        return new Citizen(id, name, surname, birthdate, fiscalCode, address, idNumber);
    }


}
