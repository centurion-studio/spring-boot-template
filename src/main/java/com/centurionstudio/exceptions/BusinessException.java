package com.centurionstudio.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends GeneralException {

    private final ExceptionType.Business type;

    public BusinessException(ExceptionType.Business type) {
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, SourceSystem sourceSystem) {
        super(sourceSystem);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, String message) {
        super(message);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, SourceSystem sourceSystem, String message) {
        super(sourceSystem, message);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, SourceSystem sourceSystem, String message, Throwable cause) {
        super(sourceSystem, message, cause);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public BusinessException(ExceptionType.Business type, SourceSystem sourceSystem, Throwable cause) {
        super(sourceSystem, cause);
        this.type = type;
    }
}
