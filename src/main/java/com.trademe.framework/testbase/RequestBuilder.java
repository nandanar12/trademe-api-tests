package com.trademe.framework.testbase;

import com.trademe.framework.config.ConfigPropertiesLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigPropertiesLoader.baseUri())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }
}
