package com.trademe.api.clients;

import com.trademe.framework.config.ConfigPropertiesLoader;
import com.trademe.framework.testbase.RequestBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetLatestListingApi {

    public Response getLatestListingsResponse() {
        return given().spec((RequestBuilder.request()))
                .auth()
                .oauth(ConfigPropertiesLoader.consumerKey(), ConfigPropertiesLoader.consumerSecret(), "", "")
                .accept("application/json")
                .log().ifValidationFails()
                .when()
                .get(ConfigPropertiesLoader.latestPath());
    }
}
