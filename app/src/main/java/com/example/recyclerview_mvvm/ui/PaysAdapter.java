package com.example.recyclerview_mvvm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_mvvm.MainActivity;
import com.example.recyclerview_mvvm.model.Pays;
import com.example.recyclerview_mvvm.ui.PaysAdapter;

import com.example.recyclerview_mvvm.model.Pays;
import com.example.recyclerview_mvvm.R;
import com.example.recyclerview_mvvm.model.Pays;

import java.util.ArrayList;
import java.util.List;

public class PaysAdapter extends RecyclerView.Adapter<PaysAdapter.ViewHolder> {

    private List<Pays> paysList;
    private OnItemClickListener onItemClickListener;



    public void setData(List<Pays> paysList) {
        this.paysList = paysList;
        this.notifyDataSetChanged();
    }

    private Context context;

    public PaysAdapter(Context context, List<Pays> paysList,OnItemClickListener ont) {
        this.context = context;
        this.paysList = paysList;
        this.onItemClickListener = ont;
    }
    public interface OnItemClickListener {
        void onItemClick(Pays pays);
    }

    // Setter method for the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pays_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pays currentPays = paysList.get(position);
        holder.text01.setText(currentPays.getNom());
        holder.text02.setText(currentPays.getCapital());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onItemClickListener.onItemClick(paysList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return paysList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text01,text02;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text01 = itemView.findViewById(R.id.text01);
            text02 = itemView.findViewById(R.id.text02);
            linearLayout = itemView.findViewById(R.id.linear01);
        }
    }
}