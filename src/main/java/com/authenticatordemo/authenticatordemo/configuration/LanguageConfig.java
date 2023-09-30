package com.authenticatordemo.authenticatordemo.configuration;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class LanguageConfig {
    public static final List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("fr"),
            new Locale("es"),
            new Locale("zh", "CN")
    );
}
