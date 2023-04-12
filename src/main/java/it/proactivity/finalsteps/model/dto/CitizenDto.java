package it.proactivity.finalsteps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDto {

    private String name;

    private String surname;

    private String birthdate;

    private String fiscalCode;

    private String address;

    private String idNumber;

}
