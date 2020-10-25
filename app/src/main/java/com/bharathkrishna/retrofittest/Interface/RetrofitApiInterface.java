package com.bharathkrishna.retrofittest.Interface;

import com.bharathkrishna.retrofittest.Pojos.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeros();


}
