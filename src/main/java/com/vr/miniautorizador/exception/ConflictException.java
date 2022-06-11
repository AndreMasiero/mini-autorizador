package com.vr.miniautorizador.exception;

import com.vr.miniautorizador.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class ConflictException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }
}

