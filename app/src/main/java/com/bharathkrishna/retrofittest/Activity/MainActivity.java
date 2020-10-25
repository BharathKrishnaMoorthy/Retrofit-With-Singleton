package com.bharathkrishna.retrofittest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bharathkrishna.retrofittest.Adapter.RecyclerviewAdapter;
import com.bharathkrishna.retrofittest.Interface.RetrofitApiInterface;
import com.bharathkrishna.retrofittest.Pojos.Hero;
import com.bharathkrishna.retrofittest.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerviewRetrofit;
    RecyclerviewAdapter recyclerviewAdapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_fun();
        // Calling a method to display Json data ------------
        getHeros();



    }

    private void init_fun() {
        RecyclerviewRetrofit = findViewById(R.id.RecyclerviewRetrofit);
        RecyclerviewRetrofit.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getHeros() {

        //Creating a call instance using our RetrofitClient
        //here basically we are calling the method getHeroes() that we created inside
        //our API Interface
        Call<List<Hero>> call = SingletonRetrofitClient.getInstance().getRetrofitApiInterface().getHeros();

        //to perform the API call we need to call the method enqueue()
        //We need to pass a Callback with enqueue method
        //And Inside the callback functions we will handle success or failure of
        //the result that we got after the API call

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                // We got our Json data here -------------
                heroList = response.body();
                recyclerviewAdapter = new RecyclerviewAdapter(MainActivity.this, heroList);
                RecyclerviewRetrofit.setAdapter(recyclerviewAdapter);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }
}