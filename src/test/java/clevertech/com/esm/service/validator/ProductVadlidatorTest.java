package clevertech.com.esm.service.validator;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import clevertech.com.esm.service.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class ProductVadlidatorTest {
    private static final long CORRECT_ID = 1;
    private static final String PRODUCT_NAME_NULL = null;
    private static final String PRODUCT_NAME_CORRECT = "Apple";
    private static final double PRODUCT_COST_CORRECT = 200;
    private static final double PRODUCT_COST_INCORRECT = 2000000000;


    private static final Product INCORRECT_PRODUCT_NULL_NAME =
            new Product(PRODUCT_NAME_NULL, PRODUCT_COST_CORRECT, true);
    private static final Product INCORRECT_PRODUCT_COST =
            new Product( PRODUCT_NAME_CORRECT, PRODUCT_COST_INCORRECT, true);


    @Mock
    ProductVadlidator productVadlidator;

    @Test
    void testValidate_shouldThrow_incorrectName() {
        doThrow(new AppException(ErrorCode.PRODUCT_NAME_INVALID, new Object())).when(productVadlidator)
                .validate(INCORRECT_PRODUCT_NULL_NAME);
        assertThrows(AppException.class, () -> {
            productVadlidator.validate(INCORRECT_PRODUCT_NULL_NAME);
        });
    }

    @Test
    void testValidate_shouldThrow_incorrectSurName() {
        doThrow(new AppException(ErrorCode.PRODUCT_COST_INVALID, new Object())).when(productVadlidator)
                .validate(INCORRECT_PRODUCT_COST);
        assertThrows(AppException.class, () -> {
            productVadlidator.validate(INCORRECT_PRODUCT_COST);
        });
    }
}