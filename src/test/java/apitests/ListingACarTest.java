package apitests;

import com.trademe.framework.reporting.TestLog;
import com.trademe.framework.utils.PayloadLoader;
import com.trademe.api.clients.ListingACarApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.trademe.api.models.request.ListingACarRequestModel;
import com.trademe.api.models.response.ListingACarResponseModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListingACarTest{

    @Test(description = "Create car listing (POST) and validate the response")
    public void listACarAndVerifyResponse(){
        ListingACarApi listingACarApi = new ListingACarApi();

        //Passing data through json file
        ListingACarRequestModel req = PayloadLoader.load("payloads/listing_a_car.json", ListingACarRequestModel.class);
        Response res = listingACarApi.createCarListingResponse(req);
        TestLog.info("Status={}, timeMs={}", res.statusCode(), res.time());
        assertThat(res.statusCode(), anyOf(is(200), is(201)));

        ListingACarResponseModel response = res.as(ListingACarResponseModel.class);

        String msg = response.getDescription();
        Long id = response.getListingId();

        if (Boolean.TRUE.equals(response.getSuccess())) {
            assertThat(msg, equalTo("ListingId " + id + " created."));
            assertThat(id, greaterThan(0L));
        } else {
            assertThat(msg, equalTo("Insufficient balance"));
        }
    }
}
