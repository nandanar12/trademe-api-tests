package com.trademe.api.clients;

import com.trademe.framework.config.ConfigPropertiesLoader;
import com.trademe.framework.testbase.RequestBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class GetLatestListingApi {

    public Response getLatestListingsResponse() {
        return given().spec((RequestBuilder.request()))
                .auth()
                .oauth(ConfigPropertiesLoader.consumerKey(), ConfigPropertiesLoader.consumerSecret(), "", "")
                .accept("application/json")
                .when()
                .get(ConfigPropertiesLoader.latestPath())
                .then()
                .log().ifStatusCodeMatches(greaterThanOrEqualTo(400))
                .extract().response();
    }
}
