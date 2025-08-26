package com.trademe.framework.base;

public class RequestBuilder {
    private Specs(){}

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigPropertiesLoader.baseUrl())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                // mask sensitive headers in Rest Assured request logging
                .setConfig(config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .build();
    }
}
