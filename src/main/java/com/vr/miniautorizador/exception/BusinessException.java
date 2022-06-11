package com.vr.miniautorizador.exception;


import com.vr.miniautorizador.enums.ErrorCode;

import java.text.MessageFormat;

public class BusinessException extends RuntimeException implements IBaseException {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;
    private String[] errorParams;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException() {
        super();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String... errorParams) {
        super((errorParams != null) ? MessageFormat.format(errorCode.getDescription(), errorParams) : errorCode.getDescription());
        this.errorCode = errorCode;
        this.errorParams = errorParams;
    }

    public BusinessException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getDescription(), cause);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * @return the errorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }


    /**
     * @return the errorParams
     */
    public String[] getErrorParams() {
        return errorParams;
    }

}
