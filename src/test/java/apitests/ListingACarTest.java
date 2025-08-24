package apitests;

import com.trademe.framework.utils.PayLoadLoader;
import com.trademe.api.clients.ListingACarApi;
import com.trademe.framework.base.BaseUriLoader;
import org.testng.annotations.Test;
import com.trademe.api.models.request.ListingACarRequestJson;
import com.trademe.api.models.response.ListingACarResponseJson;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListingACarTest extends BaseUriLoader {

    @Test(description = "Create car listing (POST) and validate the response")
    public void listACarAndVerifyResponse(){
        ListingACarApi listingACarApi = new ListingACarApi();

        ListingACarRequestJson req = PayLoadLoader.load("payloads/listing_a_car.json", ListingACarRequestJson.class);
        ListingACarResponseJson response = listingACarApi.createCarListing(req);

        String msg = response.getDescription();
        long id = response.getListingId();

        if (Boolean.TRUE.equals(response.getSuccess())) {
            assertThat(msg, equalTo("ListingId " + id + " created."));
            assertThat(id, greaterThan(0L));
        } else {
            assertThat(msg, equalTo("Insufficient balance"));
            assertThat(id, equalTo(0L));
        }
    }
}
