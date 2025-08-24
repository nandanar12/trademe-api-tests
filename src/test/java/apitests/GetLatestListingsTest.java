package apitests;

import com.trademe.api.clients.GetLatestListingApi;
import com.trademe.framework.base.BaseUriLoader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetLatestListingsTest extends BaseUriLoader {
    @Test(description = "Validate response from GET Latest Listings API")
    public void getLatestListingsAndVerifyResponse(){
        GetLatestListingApi getLatestListingApi = new GetLatestListingApi();

        Response response = getLatestListingApi.getLatestListings();
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response");
    }
}
