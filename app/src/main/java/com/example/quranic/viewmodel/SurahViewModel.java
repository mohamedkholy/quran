package com.example.quranic.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quranic.repository.SurahRepo;
import com.example.quranic.response.SurahResponse;

public class SurahViewModel extends ViewModel {

    private SurahRepo surahRepo;

    public SurahViewModel() {

        surahRepo = new SurahRepo();
    }
    public MutableLiveData<SurahResponse> getSurah(){

        return surahRepo.getSurah();
    }
}
