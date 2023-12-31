package com.authenticatordemo.authenticatordemo.utils.language;

import com.authenticatordemo.authenticatordemo.configuration.LanguageConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Component
public class CustomLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
       String language = request.getHeader("Accept-Language");
       if (language == null || language.isEmpty()) {
           // Set default language as English
           return Locale.forLanguageTag("en");
       }
       Locale locale = Locale.forLanguageTag(language);
       if (LanguageConfig.LOCALES.contains(locale)) {
           return locale;
       }
       return Locale.forLanguageTag("en");
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
