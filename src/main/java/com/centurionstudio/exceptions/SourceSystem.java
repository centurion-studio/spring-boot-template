package com.centurionstudio.exceptions;

import lombok.Getter;

@Getter
public enum SourceSystem {

    SPRING_BOOT_SERVICE("SPRING-BOOT-SERVICE");

    private final String value;

    SourceSystem(String value) {
        this.value = value;
    }
}
