package com.ssau.lori.serverapi;

public class ApiConfig {
    enum ApiEndpoints {
        DEBUG("http://10.0.2.2:8080/app/#!/");

        String url;

        ApiEndpoints(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    static ApiEndpoints endpoint = ApiEndpoints.DEBUG;

    public static String getEndpoint() {
        return endpoint.getUrl();
    }
}
