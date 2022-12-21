package clevertech.com.esm.service.validator;

import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.service.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class CustomerValidatorTest {

    private static final long CORRECT_ID = 1;
    private static final String INCORRECT_NAME_NULL = null;
    private static final String CORRECT_NAME = "name";
    private static final String INCORRECT_NAME_TOO_LONG_NAME = "long_name_long_name_long_name_" +
            "long_name_long_name_long_name_long_name_long_name_long_name_long_name_long_name_long_name";
    private static final String CORRECT_SURNAME = "surname";
    private static final String INCORRECT_SURNAME_TOO_LONG_SURNAME = "long_name_long_name_long_name_" +
            "long_name_long_name_long_name_long_name_long_name_long_name_long_name_long_name_long_name";


    private static final CustomerDTO INCORRECT_CUSTOMER_NULL_NAME =
            new CustomerDTO(CORRECT_ID, INCORRECT_NAME_NULL, CORRECT_SURNAME);
    private static final CustomerDTO INCORRECT_CUSTOMER_NAME =
            new CustomerDTO(CORRECT_ID, INCORRECT_NAME_TOO_LONG_NAME, CORRECT_SURNAME);
    private static final CustomerDTO INCORRECT_CUSTOMER_SURNAME =
            new CustomerDTO(CORRECT_ID, CORRECT_NAME, INCORRECT_SURNAME_TOO_LONG_SURNAME);

    @Mock
    CustomerValidator customerValidatorValidator;

    @Test
    void testValidate_shouldThrow_incorrectName() {
        doThrow(new AppException(ErrorCode.CUSTOMER_NAME_INVALID, new Object())).when(customerValidatorValidator)
                .validate(INCORRECT_CUSTOMER_NAME);
        assertThrows(AppException.class, () -> {
            customerValidatorValidator.validate(INCORRECT_CUSTOMER_NAME);
        });
    }

    @Test
    void testValidate_shouldThrow_incorrectSurName() {
        doThrow(new AppException(ErrorCode.CUSTOMER_SURNAME_INVALID, new Object())).when(customerValidatorValidator)
                .validate(INCORRECT_CUSTOMER_SURNAME);
        assertThrows(AppException.class, () -> {
            customerValidatorValidator.validate(INCORRECT_CUSTOMER_SURNAME);
        });
    }

    @Test
    void testValidate_shouldThrow_incorrectNameNull() {
        doThrow(new AppException(ErrorCode.CUSTOMER_NAME_INVALID, new Object())).when(customerValidatorValidator)
                .validate(INCORRECT_CUSTOMER_NULL_NAME);
        assertThrows(AppException.class, () -> {
            customerValidatorValidator.validate(INCORRECT_CUSTOMER_NULL_NAME);
        });
    }
}