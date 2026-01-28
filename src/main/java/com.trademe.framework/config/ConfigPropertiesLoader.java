package com.trademe.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesLoader {
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            PROPERTIES.load(fis);
        } catch (IOException except) {
            throw new RuntimeException("Failed to load config.properties file", except);
        }
    }

    public static String baseUri()    { return PROPERTIES.getProperty("base.uri"); }
    public static String latestPath() { return PROPERTIES.getProperty("listings.latest", "/listings/latest.json"); }
    public static String createPath() { return PROPERTIES.getProperty("listings.create", "/selling.json"); }
    public static String consumerKey()         { return PROPERTIES.getProperty("oauth.consumer.key"); }
    public static String consumerSecret()      { return PROPERTIES.getProperty("oauth.consumer.secret"); }
    public static String accessToken()         { return PROPERTIES.getProperty("oauth.accessToken"); }
    public static String tokenSecret()         { return PROPERTIES.getProperty("oauth.tokenSecret"); }
}