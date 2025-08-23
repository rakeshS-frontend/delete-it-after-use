package com.myplantdiary.enterprise.retrofit;

import com.myplantdiary.enterprise.dto.Plants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;
import java.util.List;

/**
 * Calling another service as a client via interface. Runtime will generate the
 * implementing class.
 */
public interface IRetrofitPlantRepository {
    @GET("/discospiff/data/refs/heads/main/allplants.json")
    Call<List<Plants>> lookUpPlants() throws IOException;

}
//https://raw.githubusercontent.com/discospiff/data/refs/heads/main/allplants.json