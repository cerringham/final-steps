package it.proactivity.finalsteps.builder;

import it.proactivity.finalsteps.model.dto.CitizenDto;

public class CitizenDTOBuilder {

    private final String name;

    private String surname;

    private String birthdate;

    private String fiscalCode;

    private String address;

    private String idNumber;

    private CitizenDTOBuilder(String name) {
        this.name = name;
    }

    public static CitizenDTOBuilder newBuilder(String name) {
        return new CitizenDTOBuilder(name);
    }

    public CitizenDTOBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public CitizenDTOBuilder birthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public CitizenDTOBuilder fiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
        return this;
    }

    public CitizenDTOBuilder address(String address) {
        this.address = address;
        return this;
    }

    public CitizenDTOBuilder idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    public CitizenDto build() {
        return new CitizenDto(name, surname, birthdate, fiscalCode, address, idNumber);
    }
}
