package com.vr.miniautorizador.exception;

import com.vr.miniautorizador.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}

