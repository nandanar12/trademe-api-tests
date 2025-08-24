package com.trademe.api.clients;

import com.trademe.api.models.request.ListingACarRequestJson;
import com.trademe.api.models.response.ListingACarResponseJson;
import com.trademe.framework.config.ConfigPropertiesLoader;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ListingACarApi {

    public ListingACarResponseJson createCarListing(ListingACarRequestJson req) {
        return given()
                .auth()
                .oauth(ConfigPropertiesLoader.consumerKey(), ConfigPropertiesLoader.consumerSecret(), ConfigPropertiesLoader.accessToken(), ConfigPropertiesLoader.tokenSecret())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().ifValidationFails()
                .body(req)
                .when()
                .post(ConfigPropertiesLoader.createPath())
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .extract()
                .as(ListingACarResponseJson.class);
    }
}
