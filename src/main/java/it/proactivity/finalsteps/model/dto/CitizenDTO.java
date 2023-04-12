package it.proactivity.finalsteps.model.dto;

import it.proactivity.finalsteps.model.Citizen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDTO {

    private String name;

    private String surname;

    private String birthdate;

    private String fiscalCode;

    private String address;

    private String idNumber;

}
