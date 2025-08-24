package com.trademe.api.clients;

import com.trademe.framework.config.ConfigPropertiesLoader;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetLatestListingApi {

    public Response getLatestListings() {
        return given()
                .auth()
                .oauth(ConfigPropertiesLoader.consumerKey(), ConfigPropertiesLoader.consumerSecret(), "", "")
                .log().ifValidationFails()
                .when()
                .get(ConfigPropertiesLoader.latestPath());
    }
}
