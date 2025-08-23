package com.myplantdiary.enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Plants {
    /**
     * Retrofit(okHttp)-> We are using Retrofit to call another service to fetch plant
     * data. Retrofit is useful when expecting a  type other than json.
     * Use Retrofit for Android clients in all cases (REST or SOAP, server or
     * mobile-hosted service) due to its mobile-friendly design.
     *
     * Spring based or java based client -> Use Spring-WS or WebClient for Spring Boot clients, especially for
     * SOAP or reactive REST scenarios, regardless of the remote service’s platform.
     * The remote service being mobile-hosted doesn’t change the client’s tool preference
     * but requires additional infrastructure for accessibility (e.g., IP resolution).
     */
    @SerializedName("id")
    private Integer id;
    @SerializedName("genus")
    private String genus;
    @SerializedName("species")
    private String species;
    @SerializedName("cultivar")
    private String cultivar;
    @SerializedName("common")
    private String common;


}
