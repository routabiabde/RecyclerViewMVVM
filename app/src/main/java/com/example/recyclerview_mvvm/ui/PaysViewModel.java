package com.example.recyclerview_mvvm.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_mvvm.model.Pays;

import java.util.ArrayList;
import java.util.List;

public class PaysViewModel extends androidx.lifecycle.ViewModel {
    public  MutableLiveData<List<Pays>> mutableLivePaysData = new MutableLiveData<>();

    public LiveData<List<Pays>> getMutableLivePaysData(){
        mutableLivePaysData.setValue(getPaysData());
        return mutableLivePaysData;
    }

    public List<Pays> getPaysData(){
        return Pays.listPays;
    }

}
