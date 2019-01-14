package com.example.doubea.firebasekitchensink.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.doubea.firebasekitchensink.R;
import com.example.doubea.firebasekitchensink.Utils.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Random;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StorageActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private int PICK_IMAGE_REQUEST = 1;

    @BindView(R.id.storage_fileName_EditText)
    EditText filenameEditText;

    @BindView(R.id.storage_addFile_Button)
    Button addFileButton;

    @BindView(R.id.storage_upload_Button)
    Button uploadButton;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.storage_imageView)
    ImageView imageView;


    private StorageReference mStorageRef;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        ButterKnife.bind(this);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.logEvent(Constants.EventTags.StorageActivityCreated,null);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        addFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uri!=null) {
                    Upload(uri);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            imageView.setImageURI(uri);
        }
    }

    void Upload(Uri file)
    {
        progressBar.setVisibility(View.VISIBLE);

        String filename = filenameEditText.getText().toString();
        if(filename.length() == 0)
        {
            Random rand = new Random();
            filename = "Test" + rand.nextInt(10000);
        }
        StorageReference riversRef = mStorageRef.child("images/"+  filename + ".jpg");

        riversRef.putFile(file)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT);
                        toast.show();
                        progressBar.setVisibility(View.GONE);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Upload Failed" + exception, Toast.LENGTH_SHORT);
                        toast.show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}

