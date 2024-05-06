package com.centurionstudio.exceptions;

import lombok.Getter;

@Getter
public class TechnicalException extends GeneralException {

    private final ExceptionType.Technical type;

    public TechnicalException(ExceptionType.Technical type) {
        this.type = type;
    }

    public TechnicalException(SourceSystem sourceSystem, ExceptionType.Technical type) {
        super(sourceSystem);
        this.type = type;
    }

    public TechnicalException(String message, ExceptionType.Technical type) {
        super(message);
        this.type = type;
    }

    public TechnicalException(SourceSystem sourceSystem, String message, ExceptionType.Technical type) {
        super(sourceSystem, message);
        this.type = type;
    }

    public TechnicalException(String message, Throwable cause, ExceptionType.Technical type) {
        super(message, cause);
        this.type = type;
    }

    public TechnicalException(SourceSystem sourceSystem, String message, Throwable cause, ExceptionType.Technical type) {
        super(sourceSystem, message, cause);
        this.type = type;
    }

    public TechnicalException(Throwable cause, ExceptionType.Technical type) {
        super(cause);
        this.type = type;
    }

    public TechnicalException(SourceSystem sourceSystem, Throwable cause, ExceptionType.Technical type) {
        super(sourceSystem, cause);
        this.type = type;
    }
}
