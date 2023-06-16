package com.example.studentdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
   List<Item> items;


    public Adapter(Context context, List<Item>items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameview.setText(items.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}


