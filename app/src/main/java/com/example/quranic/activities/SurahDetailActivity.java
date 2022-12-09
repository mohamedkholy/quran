package com.example.quranic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quranic.R;
import com.example.quranic.adapter.SurahDetailAdapter;
import com.example.quranic.common.Common;
import com.example.quranic.model.SurahDetail;
import com.example.quranic.response.SurahDetailResponse;
import com.example.quranic.viewmodel.SurahDetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailActivity extends AppCompatActivity {

    private TextView surahName,surahType,surahTranslation;
    private int no;
    private RecyclerView recyclerView;
    private List<SurahDetail> list;
    private SurahDetailAdapter adapter;
    private SurahDetailViewModel surahDetailViewModel;
    private String urdu = "urdu_junagarhi";
    private String hind = "hindi_omar";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        surahName = findViewById(R.id.surah_name);
        surahType = findViewById(R.id.type);
        surahTranslation = findViewById(R.id.translation);
        recyclerView = findViewById(R.id.surah_detail_rv);

        no = getIntent().getIntExtra(Common.SURAH_NO, 0);
        surahName.setText(getIntent().getStringExtra(Common.SURAH_NAME));

        surahType.setText(getIntent().getStringExtra(Common.SURAH_TYPE) +" "+
                getIntent().getStringExtra(Common.SURAH_TOTAL_AYA)+" AYA");

        surahTranslation.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));

        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();

        surahTranslation(urdu,no);



    }

    private void surahTranslation(String lan, int id) {

        if (list.size()>0){

            list.clear();
        }

        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);
        surahDetailViewModel.getSurahDetail(lan, id).observe(this, surahDetailResponse ->{


                  for (int i=0; i<surahDetailResponse.getList().size(); i++){

                      list.add(new SurahDetail(SurahDetailResponse.getList().get(i).getId(),
                              SurahDetailResponse.getList().get(i).getSura(),
                              SurahDetailResponse.getList().get(i).getAya(),
                              SurahDetailResponse.getList().get(i).getArabic_text(),
                              SurahDetailResponse.getList().get(i).getTranslation(),
                              SurahDetailResponse.getList().get(i).getFootnotes()));
                  }

                  if (list.size()!=0){

                      adapter = new SurahDetailAdapter(this,list);
                      recyclerView.setAdapter(adapter);
                  }
        });

    }
}