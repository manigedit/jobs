package com.example.jobs.api;

import com.example.jobs.model.locationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("locations")
    Call <List<locationResponse>> getLocations();


}
