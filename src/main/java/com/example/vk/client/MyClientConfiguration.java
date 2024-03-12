package com.example.vk.client;


import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


@Configuration
public class MyClientConfiguration {

    @Bean
    public OkHttpClient client() {
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(5000, MILLISECONDS)
                .readTimeout(5000, MILLISECONDS);

        return new OkHttpClient(builder.build());
    }

//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            requestTemplate.header("Content-Type", "application/json");
//            requestTemplate.header("Accept", "application/json");
//            requestTemplate.header("Authorization", "Token " + apiToken);
//            requestTemplate.header("X-Secret", secretToken);
//        };
//    }
}