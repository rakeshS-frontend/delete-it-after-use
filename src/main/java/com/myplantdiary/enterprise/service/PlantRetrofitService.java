package com.myplantdiary.enterprise.service;

import com.myplantdiary.enterprise.dto.Plants;
import com.myplantdiary.enterprise.retrofit.IRetrofitPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Component
public class PlantRetrofitService {

    @Autowired
    private Retrofit retrofit;


    public List<Plants> lookUpPlants() throws IOException {
        IRetrofitPlantRepository iPantRetrofitService = retrofit.create(IRetrofitPlantRepository.class);
        Call<List<Plants>> plants = iPantRetrofitService.lookUpPlants();
        List<Plants> plantsList = plants.execute().body();
        System.out.println(plantsList.size());
        return plantsList;
    }
}
