package clevertech.com.esm.exceptions;

import java.time.LocalDateTime;

public class CustomErrorResponse {
    private String message;
    private String code;
    private LocalDateTime time;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}