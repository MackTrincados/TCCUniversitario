package com.example.appuniversitario.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appuniversitario.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    String data1[], data2[], data3[];
    int images[];
    Context context;
    public FeedAdapter(Context ct, String s1[], String s2[], String s3[], int imagenss[])
    {
        context = ct;
        data1 = s1;
        data2 =s2;
        data3 = s3;
        images = imagenss;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_feed,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.text3.setText(data3[position]);
        holder.image1.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data2.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView text1, text2, text3;
        ImageView image1;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            text1 = itemView.findViewById(R.id.txtNomesFeed);
            text2 = itemView.findViewById(R.id.txtDescricaoFeed);
            text3 = itemView.findViewById(R.id.txtMaterias2);
            image1 = itemView.findViewById(R.id.imageViewFeed);
        }
    }
}
