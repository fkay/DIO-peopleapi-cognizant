package com.fxii.personapi.utils;

import com.fxii.personapi.dto.request.PhoneDTO;
import com.fxii.personapi.entity.Phone;
import com.fxii.personapi.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "(11)9999-8888";
    private static final PhoneType PHONE_TYPE = PhoneType.CELULAR;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

}
