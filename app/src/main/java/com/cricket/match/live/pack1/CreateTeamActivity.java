package com.cricket.match.live.pack1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.Random;

public class CreateTeamActivity extends AppCompatActivity {


    ImageView imageuplaod;
    EditText etidname,etidage,etidaddress;
    Uri filepath;
    Bitmap bitnap;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);
        imageuplaod = findViewById(R.id.imageuplaod);
        btnsubmit = findViewById(R.id.btnsubmit);

        imageuplaod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Dexter.withContext(CreateTeamActivity.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)

                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"selectimage"),1);

                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                            }
                        }).check();

            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadtofirebase();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){

            filepath = data.getData();

            try {
                InputStream inputStream = getContentResolver()
                        .openInputStream(filepath);
                bitnap = BitmapFactory.decodeStream(inputStream);
                imageuplaod.setImageBitmap(bitnap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadtofirebase() {

        ProgressDialog dailog = new ProgressDialog(this);
        dailog.setTitle("processing");
        dailog.show();

        etidaddress = findViewById(R.id.etidaddress);
        etidage = findViewById(R.id.etidage);
        etidname = findViewById(R.id.etidname);
        imageuplaod = findViewById(R.id.imageuplaod);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference uploader = storage.getReference("Image"+new Random().nextInt(50));

        uploader.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                           @Override
                           public void onSuccess(Uri uri) {
                               dailog.dismiss();


                               FirebaseDatabase database = FirebaseDatabase.getInstance();
                               DatabaseReference root = database.getReference("User");

//                               final String uniquekey = root.push().getKey();
                               final String uniquekey= root.push().getKey();

                               ModelClass modelClass = new ModelClass(
                                       uri.toString().toString(),
                                       etidname.getText().toString(),etidaddress.getText().toString(),
                                       etidage.getText().toString());


                               root.child(uniquekey).setValue(modelClass);
                               etidaddress.setText("");
                               etidage.setText("");
                               etidname.setText("");
                               imageuplaod.setImageResource(R.drawable.camera);
//                               Intent intent = new Intent(getApplicationContext(),)
                               Toast.makeText(CreateTeamActivity.this, "data upladed", Toast.LENGTH_SHORT).show();


                           }
                       });
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

                        float persent = (100*snapshot.getBytesTransferred())/
                                snapshot.getTotalByteCount();
                        dailog.setMessage("Data Uploded : "+(int)persent+"%");

                    }
                });





    }
}