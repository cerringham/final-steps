package it.proactivity.finalsteps.utility;

import it.proactivity.finalsteps.model.dto.CitizenDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CitizenValidator {

    private static final Integer CITIZEN_NAME_AND_SURNAME_MAX_LENGTH = 50;
    private static final Integer CITIZEN_FISCAL_CODE_MAX_LENGTH = 16;
    private static final Integer CITIZEN_ID_NUMBER_MAX_LENGTH = 10;
    private static final Integer CITIZEN_ADDRESS_MAX_LENGTH = 100;

    @Autowired
    ParsingUtility parsingUtility;

    public Boolean validateId(Long id) {
        return id != null;
    }

    public Boolean validateCitizenDto(CitizenDto citizenDto) {
        if (citizenDto == null) {
            return false;
        }
        return validateName(citizenDto.getName()) && validateSurname(citizenDto.getSurname()) &&
                validateAddress(citizenDto.getAddress()) && validateBirthdate(citizenDto.getBirthdate()) &&
                validateIdNumber(citizenDto.getIdNumber()) && validateFiscalCode(citizenDto.getFiscalCode());
    }

    private Boolean validateName(String name) {

        if (StringUtils.isEmpty(name)) {
            return false;
        }
        return StringUtils.isAlpha(name) && name.length() <= CITIZEN_NAME_AND_SURNAME_MAX_LENGTH;
    }

    private Boolean validateSurname(String surname) {

        if (StringUtils.isEmpty(surname)) {
            return false;
        }
        return StringUtils.isAlphaSpace(surname) && surname.length() <= CITIZEN_NAME_AND_SURNAME_MAX_LENGTH;
    }

    private Boolean validateFiscalCode(String fiscalCode) {
        if (StringUtils.isEmpty(fiscalCode)) {
            return false;
        }
        return StringUtils.isAlpha(fiscalCode.substring(0, 6)) && StringUtils.isNumeric(fiscalCode.substring(6, 8)) &&
                StringUtils.isAlpha(fiscalCode.substring(8, 9)) && StringUtils.isNumeric(fiscalCode.substring(9, 11)) &&
                StringUtils.isAlpha(fiscalCode.substring(11, 12)) && StringUtils.isNumeric(fiscalCode.substring(12, 15)) &&
                StringUtils.isAlpha(fiscalCode.substring(15)) &&
                fiscalCode.length() == CITIZEN_FISCAL_CODE_MAX_LENGTH;
    }

    private Boolean validateIdNumber(String idNumber) {
        if (StringUtils.isEmpty(idNumber)) {
            return false;
        }

        return StringUtils.isAlphanumeric(idNumber) && idNumber.length() <= CITIZEN_ID_NUMBER_MAX_LENGTH;
    }

    private Boolean validateAddress(String address) {
        if (StringUtils.isEmpty(address)) {
            return false;
        }
        return address.length() <= CITIZEN_ADDRESS_MAX_LENGTH;
    }

    private Boolean validateBirthdate(String birthdate) {
        if (StringUtils.isEmpty(birthdate)) {
            return false;
        }
        LocalDate parsedBirthDate = parsingUtility.parseStringToLocalDate(birthdate);
        return parsedBirthDate != null;

    }
}
