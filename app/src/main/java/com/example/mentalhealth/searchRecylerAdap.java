package com.example.mentalhealth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class searchRecylerAdap extends RecyclerView.Adapter<searchRecylerAdap.ViewHolder> {
    private ArrayList<User> listUser = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recherche_item, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameSearchResult.setText(listUser.get(position).getName());
        holder.imgSearchResult.setImageResource(R.drawable.account_icon);

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameSearchResult;
        private ImageView imgSearchResult;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSearchResult= itemView.findViewById(R.id.searchResultText);
            imgSearchResult = itemView.findViewById(R.id.searchResultPic);


        }
    }
}
