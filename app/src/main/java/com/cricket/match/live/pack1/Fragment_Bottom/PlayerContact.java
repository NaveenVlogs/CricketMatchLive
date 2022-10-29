package com.cricket.match.live.pack1.Fragment_Bottom;

import android.content.ClipData;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cricket.match.live.pack1.ContactAdapter;
import com.cricket.match.live.pack1.Model_Contact;
import com.cricket.match.live.pack1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerContact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerContact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView player_contact_recyclerview;
    ArrayList<Model_Contact>playerlist;
//    EditText etidsearch;
    SearchView searchview1;
    ContactAdapter contactAdapter;


    public PlayerContact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayerContact.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerContact newInstance(String param1, String param2) {
        PlayerContact fragment = new PlayerContact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_player_contact, container, false);

       player_contact_recyclerview = v.findViewById(R.id.player_contact_recyclerview);
        player_contact_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//        etidsearch = v.findViewById(R.id.etidsearch);
//        etidsearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//               filter(editable.toString());
//
//            }
//        });

        searchview1 = v.findViewById(R.id.searchview1);
        searchview1.clearFocus();
        searchview1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);
                return true;
            }
        });













        playerlist = new ArrayList<>();

        Model_Contact ob1 = new Model_Contact(R.drawable.mangu1,00000000,"mangu dholaniya");
        playerlist.add(ob1);

        Model_Contact ob2 = new Model_Contact(R.drawable.pintu1,00000000,"prience pal");
        playerlist.add(ob2);
        Model_Contact ob3 = new Model_Contact(R.drawable.nishu1,00000000,"Nishu Singh");
        playerlist.add(ob3);
        Model_Contact ob4 = new Model_Contact(R.drawable.amrish1,00000000,"amrish pipil");
        playerlist.add(ob4);
        Model_Contact ob5 = new Model_Contact(R.drawable.tinku1,00000000,"Tinku dholaniya");
        playerlist.add(ob5);
        Model_Contact ob6 = new Model_Contact(R.drawable.nitin1,00000000,"Nitin Kakran");
        playerlist.add(ob6);
        Model_Contact ob7 = new Model_Contact(R.drawable.gaurav1,00000000,"Gaurav pal dholaniya");
        playerlist.add(ob7);
        Model_Contact ob8 = new Model_Contact(R.drawable.anshul1,00000000,"Anshul");
        playerlist.add(ob8);
        Model_Contact ob9 = new Model_Contact(R.drawable.aakash1,00000000,"Love Kumar");
        playerlist.add(ob9);
        Model_Contact ob10 = new Model_Contact(R.drawable.love1,00000000,"Aakash ");
        playerlist.add(ob10);
        player_contact_recyclerview.setAdapter(new ContactAdapter(playerlist));



       return v;
    }

    private void filterList(String text) {
       ArrayList<Model_Contact>filterList = new ArrayList<>();
        for (Model_Contact model_contact : playerlist){
            if (model_contact.getName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(model_contact);
            }
        }
        if (filterList.isEmpty()){
            Toast.makeText(getContext(), "no Data Found ", Toast.LENGTH_SHORT).show();

        }else {
            contactAdapter.setFilterdList(filterList);

        }





    }
//    private void filter(String text){
//         ArrayList<Model_Contact> filterList = new ArrayList<>();
//         for (Model_Contact item : playerlist){
//             if (item.getName().toLowerCase().contains(text.toLowerCase())) {
//                 filterList.add(item);
//
//
//             }
//         }
//         contactAdapter.filterList(filterList);
//
//    }
}