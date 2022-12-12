package com.example.quranic.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Retrofit instance;
    public static Retrofit instance2;

    public static Retrofit getRetrofit(){

        if (instance==null){

            instance = new Retrofit.Builder().baseUrl("https://api.alquran.cloud/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }

    public static Retrofit getInstance(){

        if (instance==null){
        instance=null;
            }




            instance2 = new Retrofit.Builder().baseUrl("https://quranenc.com/api/v1/translation/")


                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        return instance2;
    }
}
