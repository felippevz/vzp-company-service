package dev.felippevaz.vzp_company_service.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {

    private final String code;
    private final Object[] args;
    private final HttpStatus status;

    public ServiceException(String code, HttpStatus status, Object... args) {
        super(code);
        this.code = code;
        this.args = args;
        this.status = status;
    }
}
