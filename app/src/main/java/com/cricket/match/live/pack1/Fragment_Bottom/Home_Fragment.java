package com.cricket.match.live.pack1.Fragment_Bottom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cricket.match.live.pack1.Live_Video_Fragment;
import com.cricket.match.live.pack1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RelativeLayout recycler1,recycler2,recycler3,recycler4;


    public Home_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_home_, container, false);
        recycler1= view.findViewById(R.id.recycler1);
        recycler2= view.findViewById(R.id.recycler2);
        recycler3= view.findViewById(R.id.recycler3);
        recycler4= view.findViewById(R.id.recycler4);

        recycler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
//                bundle.putString("Key",etidtext.getText().toString());
              TeamFragment fragment = new TeamFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.framlayout1,fragment).commit();

            }
        });

        recycler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                PlayerContact contact = new PlayerContact();
                contact.setArguments(bundle1);
                getFragmentManager().beginTransaction().replace(R.id.framlayout1,contact).commit();

            }
        });

        recycler3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle3 = new Bundle();
                Players_down_Fragment players_down_fragment = new Players_down_Fragment();
                players_down_fragment.setArguments(bundle3);
                getFragmentManager().beginTransaction().replace(R.id.framlayout1,players_down_fragment).commit();
            }
        });

        recycler4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle4 = new Bundle();
                Live_Video_Fragment live_video_fragment = new Live_Video_Fragment();
                live_video_fragment.setArguments(bundle4);
                getFragmentManager().beginTransaction().replace(R.id.framlayout1,live_video_fragment).commit();

            }
        });


        return view;
    }
}