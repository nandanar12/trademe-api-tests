package com.trademe.api.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//ListingRequest POJO
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingACarRequestJson {
    @JsonProperty("Category")
    public String category;
    @JsonProperty("Description")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<String> description;
    @JsonProperty("StartPrice")
    public BigDecimal startPrice;
    @JsonProperty("Duration")
    public String duration;
    @JsonProperty("Pickup")
    public String pickup;
    @JsonProperty("SendPaymentInstructions")
    public Boolean sendPaymentInstructions;
    @JsonProperty("IsBold")
    public Boolean isBold;
    @JsonProperty("ShippingOptions")
    public List<ShippingOption> shippingOptions;
    @JsonProperty("PaymentMethods")
    public List<String> paymentMethods;
    @JsonProperty("Attributes")
    public List<Attribute> attributes;

    @Data
    public static class ShippingOption {
        @JsonProperty("Type")
        private String type;
    }

    @Data
    public static class Attribute {
        @JsonProperty("Name")
        private String name;
        @JsonProperty("Value")
        private String value;
    }
}
