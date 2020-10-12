package com.example.appuniversitario.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuniversitario.R;

import java.util.List;

public class NotificacoesAdapter extends RecyclerView.Adapter<NotificacoesAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;


    public NotificacoesAdapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.home_notificacoes, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //bind textview with data received

        String title = data.get(i);
        viewHolder.textTitleN.setText(title);

        //Similarly you can set new image for each card and descriptions
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitleN, textDescriptionN;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitleN = itemView.findViewById(R.id.textTitleN);
            textDescriptionN = itemView.findViewById(R.id.textDescN);
        }
    }

}
