package com.trademe.api.models.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(exclude = {"statusCode", "timeMs"})
public class ListingACarResponseModel {

    @JsonProperty("Success")
    @JsonAlias({"success", "IsSuccess"})
    private Boolean success;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("ListingId")
    private Long listingId;

    @JsonIgnore
    private int statusCode;

    @JsonIgnore
    private long timeMs;
}
