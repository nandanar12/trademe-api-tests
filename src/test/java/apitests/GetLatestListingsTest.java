package apitests;

import com.trademe.api.clients.GetLatestListingApi;
import com.trademe.framework.reporting.TestLog;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetLatestListingsTest {

    @Test(description = "Validate response from GET Latest Listings API")
    public void getLatestListingsAndVerifyResponse() {
        GetLatestListingApi getLatestListingApi = new GetLatestListingApi();

        Response response = getLatestListingApi.getLatestListingsResponse();
        TestLog.info("Status={}, timeMs={}", response.statusCode(), response.time());
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response");

    }
}
