package com.trademe.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class PayloadLoader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T load(String classpathPath, Class<T> type) {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(classpathPath)) {
            if (in == null) {
                throw new IllegalStateException(classpathPath + " not found on classpath");
            }
            return MAPPER.readValue(in, type);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read " + classpathPath, e);
        }
    }
}