package com.example.quranic.repository;

import androidx.lifecycle.MutableLiveData;



import com.example.quranic.network.Api;
import com.example.quranic.network.JsonPlaceHolderApi;
import com.example.quranic.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SurahRepo {

    private final JsonPlaceHolderApi jsonPlaceHolderApi;


    public SurahRepo() {

        jsonPlaceHolderApi = Api.getRetrofit().create(JsonPlaceHolderApi.class);
    }

    public MutableLiveData<SurahResponse> getSurah() {

        MutableLiveData<SurahResponse> data = new MutableLiveData<>();



        jsonPlaceHolderApi.getSurah().enqueue(new Callback<SurahResponse>() {
            @Override
            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahResponse> call, Throwable t) {

                data.setValue(null);
            }
        });


        return data;
    }
}




