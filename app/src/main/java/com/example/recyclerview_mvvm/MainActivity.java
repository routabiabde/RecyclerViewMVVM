package com.example.recyclerview_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recyclerview_mvvm.model.Pays;
import com.example.recyclerview_mvvm.ui.PaysAdapter;
import com.example.recyclerview_mvvm.ui.PaysViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PaysViewModel paysViewModel;
    PaysAdapter paysAd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        paysViewModel = new ViewModelProvider(this).get(PaysViewModel.class);
        btn = findViewById(R.id.btn);
        paysAd = new PaysAdapter(this, new ArrayList<>(), new PaysAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pays pays) {
                btn.setText(pays.getNom());
            }
        });

        paysViewModel.getMutableLivePaysData().observe(this, new Observer<List<Pays>>() {
            @Override
            public void onChanged(List<Pays> pays) {
//                Log.d("RecyclerView", "Data changed. Size: " + pays.size());
                paysAd.setData(pays);

            }
        });

        recyclerView.setAdapter(paysAd);




    }

}