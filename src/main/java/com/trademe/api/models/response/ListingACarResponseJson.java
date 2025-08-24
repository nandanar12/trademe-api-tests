package com.trademe.api.models.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

//ListingACarResponse POJO
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingACarResponseJson {

    @JsonProperty("Success")
    private Boolean success;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("ListingId")
    private long listingId;
}
