package com.trademe.framework.base;
import com.trademe.framework.config.ConfigPropertiesLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseUriLoader {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigPropertiesLoader.baseUri();
    }
}
