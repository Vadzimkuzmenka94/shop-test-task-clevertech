package clevertech.com.esm.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public enum ErrorCode {
    CUSTOMER_NOT_FOUND("CUSTOMER_1", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    PRODUCT_NOT_FOUND("PRODUCT_1", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    PURCHASE_NOT_FOUND("PURCHASE_1", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    CUSTOMER_INVALID("CUSTOMER_2", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    PRODUCT_INVALID("PRODUCT_2", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    PURCHASE_INVALID("PURCHASE_2", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    PRODUCT_COST_INVALID("PRODUCT_2_2", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    PRODUCT_NAME_INVALID("PRODUCT_2_1", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    CUSTOMER_NAME_INVALID("CUSTOMER_2_1", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    CUSTOMER_SURNAME_INVALID("CUSTOMER_2_2", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    BAD_REQUEST("BAD_REQUEST", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    MESSAGE_NOT_READABLE("G1", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    METHOD_ARGUMENT_TYPE_MISMATCH("G3", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    INTERNAL_ERROR("G4", HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()),
    URL_INVALID("G5", HttpStatus.NOT_FOUND, LocalDateTime.now()),
    MEDIA_TYPE_NOT_SUPPORTED("G6", HttpStatus.BAD_REQUEST, LocalDateTime.now()),
    PASSWORD_OR_LOGIN_IS_INCORRECT("UNAUTHORIZED_1", HttpStatus.UNAUTHORIZED, LocalDateTime.now());


    private String code;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;

    ErrorCode(String code, HttpStatus httpStatus, LocalDateTime localDateTime) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.localDateTime = localDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}