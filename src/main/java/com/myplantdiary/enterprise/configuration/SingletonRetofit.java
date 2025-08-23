package com.myplantdiary.enterprise.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class SingletonRetofit {

    private static final String BASE_URL = "https://raw.githubusercontent.com";

    @Bean
    public Retrofit getSingletonRetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

}
