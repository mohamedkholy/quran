package com.example.quranic.network;


import com.example.quranic.model.Surah;
import com.example.quranic.response.SurahDetailResponse;
import com.example.quranic.response.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("surah")
   Call<SurahResponse> getSurah();



    @GET("sura/{language}/{id}")
    Call<SurahDetailResponse> getSurahDetail(@Path("language")String lan, @Path("id") int surahId);
}
