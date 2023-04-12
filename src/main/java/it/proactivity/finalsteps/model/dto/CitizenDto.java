package it.proactivity.finalsteps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDto {

    private Long id;

    private String name;

    private String surname;

    private LocalDate birthdate;

    private String fiscalCode;

    private String address;

    private String idNumber;

    public CitizenDto(String name, String surname, LocalDate birthdate, String fiscalCode, String address, String idNumber) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.fiscalCode = fiscalCode;
        this.address = address;
        this.idNumber = idNumber;
    }
}
