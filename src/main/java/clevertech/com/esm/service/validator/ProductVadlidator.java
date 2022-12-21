package clevertech.com.esm.service.validator;

import clevertech.com.esm.entities.Product;
import clevertech.com.esm.exceptions.AppException;
import clevertech.com.esm.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ProductVadlidator {
    private static final String PRODUCT_NAME = "productName";
    private static final String PRODUCT_PRICE = "productCost";
    private static final Pattern PRODUCT_NAME_REGEX = Pattern.compile("[\\w|\\s|,]{3,80}");
    private static final BigDecimal MIN_PRICE_VALUE = new BigDecimal(0.01);
    private static final BigDecimal MAX_PRICE_VALUE = new BigDecimal(10000);

    public void validate(Product product) {
        if (product.getProductName() == null) {
            throw new AppException(ErrorCode.PRODUCT_NAME_INVALID);
        }
        Matcher matcher = PRODUCT_NAME_REGEX.matcher(product.getProductName());
        if (!matcher.matches()) {
            throw new AppException(ErrorCode.PRODUCT_NAME_INVALID, PRODUCT_NAME, product.getProductName());
        }
        if (product.getProductCoast() == 0) {
            throw new AppException(ErrorCode.PRODUCT_COST_INVALID);
        }
        if (MIN_PRICE_VALUE.compareTo(BigDecimal.valueOf(product.getProductCoast())) >= 0
                || MAX_PRICE_VALUE.compareTo(BigDecimal.valueOf(product.getProductCoast())) < 0) {
            throw new AppException(ErrorCode.PRODUCT_COST_INVALID, PRODUCT_PRICE, product.getProductCoast());
        }
    }
}