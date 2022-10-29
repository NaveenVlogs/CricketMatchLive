package com.cricket.match.live.pack1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecurityActivity extends AppCompatActivity {

    EditText etid_email_video1,etid_password_video;
    Button btn_upload_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        etid_email_video1 = findViewById(R.id.etid_email_vide1);
        etid_password_video = findViewById(R.id.etid_password_video);
        btn_upload_video = findViewById(R.id.btn_upload_video);

        btn_upload_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etid_email_video1.getText().toString().trim();
                String password = etid_password_video.getText().toString().trim();

                if (email.isEmpty()){
                    etid_email_video1.setError("Confrom email here");
                    etid_email_video1.requestFocus();
                    return;
                }


                if (password.isEmpty()){
                    etid_password_video.setError("Conform Password");
                    etid_password_video.requestFocus();
                    return;
                }

                if (email.equals("nishu123@gmail.com")&& password.equals("palhera123")){

                    Toast.makeText(SecurityActivity.this, "upload clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),VideoDeshboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SecurityActivity.this, "something error", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}