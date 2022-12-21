package clevertech.com.esm.service.validator;

import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.service.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class CustomerValidator {
    private static final String CUSTOMER_NAME = "name";
    private static final String CUSTOMER_SURNAME = "surname";
    private static final Pattern NAME_REGEX = Pattern.compile("[\\w|\\s|,]{3,15}");
    private static final Pattern SURNAME_REGEX = Pattern.compile("[\\w|\\s|,]{3,20}");

    public void validate(CustomerDTO customerDTO) {
        if (customerDTO.getName() == null) {
            throw new AppException(ErrorCode.CUSTOMER_NAME_INVALID);
        }
        Matcher matcher = NAME_REGEX.matcher(customerDTO.getName());
        if (!matcher.matches()) {
            throw new AppException(ErrorCode.CUSTOMER_NAME_INVALID, CUSTOMER_NAME, customerDTO.getName());
        }
        if (customerDTO.getSurname() == null) {
            throw new AppException(ErrorCode.CUSTOMER_SURNAME_INVALID);
        }
        matcher = SURNAME_REGEX.matcher(customerDTO.getSurname());
        if (!matcher.matches()) {
            throw new AppException(ErrorCode.CUSTOMER_SURNAME_INVALID, CUSTOMER_SURNAME, customerDTO.getSurname());
        }
    }
}