package com.fxii.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    CELULAR("Celular"),
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    CONTATO ("Contato");

    private final String description;
}
