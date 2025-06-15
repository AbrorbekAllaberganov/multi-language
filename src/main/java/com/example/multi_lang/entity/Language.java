package com.example.multi_lang.entity;

import java.util.Arrays;
import java.util.Locale;

public enum Language {
    EN("en"),
    RU("ru"),
    UZ("uz");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Locale toLocale() {
        return Locale.forLanguageTag(this.code);
    }

    public static Language fromCode(String code) {
        return Arrays.stream(values())
                .filter(lang -> lang.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(EN); // fallback
    }
}
