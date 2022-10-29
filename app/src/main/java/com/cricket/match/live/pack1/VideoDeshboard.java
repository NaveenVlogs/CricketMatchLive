package com.cricket.match.live.pack1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class VideoDeshboard extends AppCompatActivity {
    FloatingActionButton floating_btn;
    RecyclerView recyclerview_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_deshboard);
        floating_btn = findViewById(R.id.floating_btn);


        recyclerview_video = findViewById(R.id.recyclerview_video);
        recyclerview_video.setLayoutManager(new LinearLayoutManager(this));

//        FirebaseRecyclerOptions<Model_Video_Uploader> options =
//                new FirebaseRecyclerOptions.Builder<Model_Video_Uploader>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("myvideos"), Model_Video_Uploader.class)
//                        .build();





        floating_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}