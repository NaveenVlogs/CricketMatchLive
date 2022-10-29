package com.cricket.match.live.pack1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.contactViewHolder> {

    ArrayList<Model_Contact>contacts;

    public ContactAdapter(ArrayList<Model_Contact> contacts) {
        this.contacts = contacts;
    }
        public void setFilterdList (List<Model_Contact>filterdList){
        this.contacts = (ArrayList<Model_Contact>) filterdList;
        notifyDataSetChanged();
        }
    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_contact_desgine,parent,false);

        return new contactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, int position) {

        holder.image_contact.setImageResource(contacts.get(position).getImage());
        holder.textname.setText(contacts.get(position).getName());
//        holder.textcontact.setText(contacts.get(position).getContact());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public void filterList(ArrayList<Model_Contact>filterList){
        contacts = filterList;
    }

    public class contactViewHolder extends RecyclerView.ViewHolder{

       CircleImageView image_contact;
        TextView textname,textcontact;

        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            image_contact = itemView.findViewById(R.id.image_contact);
            textname = itemView.findViewById(R.id.textname);
            textcontact = itemView.findViewById(R.id.textcontact);


        }
    }
}
