package com.centurionstudio.exceptions;

import lombok.Getter;

@Getter
public abstract class GeneralException extends Exception {

    private final SourceSystem sourceSystem;

    protected GeneralException() {
        this(SourceSystem.SPRING_BOOT_SERVICE);
    }

    protected GeneralException(SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    protected GeneralException(String message) {
        this(SourceSystem.SPRING_BOOT_SERVICE, message);
    }

    protected GeneralException(SourceSystem sourceSystem, String message) {
        super(message);

        this.sourceSystem = sourceSystem;
    }

    protected GeneralException(String message, Throwable cause) {
        this(SourceSystem.SPRING_BOOT_SERVICE, message, cause);
    }

    protected GeneralException(SourceSystem sourceSystem, String message, Throwable cause) {
        super(message, cause);

        this.sourceSystem = sourceSystem;
    }

    protected GeneralException(Throwable cause) {
        this(SourceSystem.SPRING_BOOT_SERVICE, cause);
    }

    protected GeneralException(SourceSystem sourceSystem, Throwable cause) {
        super(cause);

        this.sourceSystem = sourceSystem;
    }
}
