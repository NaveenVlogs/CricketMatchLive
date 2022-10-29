package com.cricket.match.live.pack1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class AddVideoActivity extends AppCompatActivity {

    VideoView video_view;
    Button brouse_btn,btn_upload;
    Uri videouri;
    MediaController mediaController1;
    EditText vtitle;
    StorageReference storageReference1;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);

        vtitle = findViewById(R.id.vtitle);
        storageReference1 = FirebaseStorage.getInstance().getReference();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("myvideos");

       video_view = findViewById(R.id.video_view);
       brouse_btn = findViewById(R.id.btn_brouse);
       btn_upload = findViewById(R.id.btn_upload);
       mediaController1 = new MediaController(this);
       video_view.setMediaController(mediaController1);
       video_view.start();

       brouse_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Dexter.withContext(getApplicationContext())
                       .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                       .withListener(new PermissionListener() {
                           @Override
                           public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                               Intent intent = new Intent();
                               intent.setType("video/*");
                               intent.setAction(Intent.ACTION_GET_CONTENT);
                               startActivityForResult(intent,101);
                           }

                           @Override
                           public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                           }

                           @Override
                           public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                           }
                       }).check();


           }
       });

       btn_upload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               processvideouploading();


           }
       });
    }
    public String getExtension()
    {
        MimeTypeMap mimeTypeMap= MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(getContentResolver().getType(videouri));

    }

    private void processvideouploading()
    {

       final ProgressDialog  pd = new ProgressDialog(this);
        pd.setTitle("media uploader");
        pd.show();

       final StorageReference uploader = storageReference1.child("myvideos/"+System.currentTimeMillis()+"."+getExtension());
        uploader.putFile(videouri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        uploader.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                Model_Video_Uploader obj = new Model_Video_Uploader(vtitle.getText().toString(),uri.toString());
                                databaseReference1.child(databaseReference1.push().getKey()).setValue(obj)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                pd.dismiss();
                                                Toast.makeText(AddVideoActivity.this, "succesfully uploaded", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                pd.dismiss();
                                                Toast.makeText(AddVideoActivity.this, "No video uploaded", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                            }
                        });

                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float per = (100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                        pd.setMessage("uploaded :"+(int)per+"%");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==101 && resultCode==RESULT_OK){

            videouri = data.getData();
            video_view.setVideoURI(videouri);
        }
    }
}