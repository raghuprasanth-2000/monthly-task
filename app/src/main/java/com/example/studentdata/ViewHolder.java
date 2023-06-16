package com.example.studentdata;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView nameview;
    public ViewHolder(View view) {
        super(view);
        nameview=itemView.findViewById(R.id.nameview);

    }
}
