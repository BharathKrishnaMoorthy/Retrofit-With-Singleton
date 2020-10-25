package com.bharathkrishna.retrofittest.Activity;

import com.bharathkrishna.retrofittest.Interface.RetrofitApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonRetrofitClient {
    private static SingletonRetrofitClient instance = null;
    private RetrofitApiInterface retrofitApiInterface;
    private SingletonRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApiInterface = retrofit.create(RetrofitApiInterface.class);
    }
    public static synchronized SingletonRetrofitClient getInstance(){
        if (instance == null){
            instance = new SingletonRetrofitClient();
        }
        return instance;
    }

    public RetrofitApiInterface getRetrofitApiInterface() {
        return retrofitApiInterface;
    }
}
