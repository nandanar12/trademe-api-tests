package com.trademe.api.clients;

import com.trademe.api.models.request.ListingACarRequestModel;
import com.trademe.framework.config.ConfigPropertiesLoader;
import com.trademe.framework.testbase.RequestBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ListingACarApi {

    public Response createCarListingResponse(ListingACarRequestModel req) {
        return given().spec(RequestBuilder.request())
                .auth()
                .oauth(ConfigPropertiesLoader.consumerKey(), ConfigPropertiesLoader.consumerSecret(), ConfigPropertiesLoader.accessToken(), ConfigPropertiesLoader.tokenSecret())
                .body(req)
                .when()
                .post(ConfigPropertiesLoader.createPath())
                .then()
                .log().ifStatusCodeMatches(greaterThanOrEqualTo(400))
                .extract().response();
    }
}
