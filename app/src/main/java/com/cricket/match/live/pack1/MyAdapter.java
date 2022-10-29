package com.cricket.match.live.pack1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    ArrayList<ModelResponse>modelResponses;

    public MyAdapter(ArrayList<ModelResponse> modelResponses) {
        this.modelResponses = modelResponses;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viwe = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new MyviewHolder(viwe);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Glide.with(holder.image_recyclerview_cart.getContext()).load(modelResponses.get(position)).into(holder.image_recyclerview_cart);
        holder.tv_recyclerview_cart.setText(modelResponses.get(position).getName());
        holder.tv2_recyclerview_cart.setText(modelResponses.get(position).getAge());
        holder.tv3_recyclerview_cart.setText(modelResponses.get(position).getAddress());




    }

    @Override
    public int getItemCount() {
        return modelResponses.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        ImageView image_recyclerview_cart;
       TextView tv_recyclerview_cart,tv2_recyclerview_cart,tv3_recyclerview_cart;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            image_recyclerview_cart = itemView.findViewById(R.id.image_recyclerview_cart);
            tv_recyclerview_cart = itemView.findViewById(R.id.tv_recyclerview_cart);
            tv2_recyclerview_cart = itemView.findViewById(R.id.tv2_recyclerview_cart);
            tv3_recyclerview_cart = itemView.findViewById(R.id.tv3_recyclerview_cart);
        }
    }
}
