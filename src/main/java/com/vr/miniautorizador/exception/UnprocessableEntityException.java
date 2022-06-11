package com.vr.miniautorizador.exception;

import com.vr.miniautorizador.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(ErrorCode errorCode) {
        super(errorCode);
    }
}

