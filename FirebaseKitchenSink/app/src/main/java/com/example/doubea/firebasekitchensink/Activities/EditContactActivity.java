package com.example.doubea.firebasekitchensink.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doubea.firebasekitchensink.Models.Contact;
import com.example.doubea.firebasekitchensink.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditContactActivity extends AppCompatActivity {

    @BindView(R.id.activity_edit_name_EditText)
    EditText name;
    @BindView(R.id.activity_edit_PhoneNumber_EditText)
    EditText phoneNumber;
    @BindView(R.id.activity_edit_delete_Button)
    Button deleteButton;
    @BindView(R.id.activity_edit_save_Button)
    Button saveButton;

    private FirebaseDatabase database;
    private DatabaseReference contactDbRef;
    private boolean isEdit;
    private String userId;
    private Contact currenctContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);


        // getIntent() is a method from the started activity
        Intent myIntent = getIntent(); // gets the previously created intent
        userId = myIntent.getStringExtra("userID");
        isEdit = myIntent.getBooleanExtra("IsEdit",false);

        ButterKnife.bind(this);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();

        contactDbRef = database.getReference("contacts");

        initData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    UUID uuid = UUID.randomUUID();
                    writeNewUser(uuid.toString(), name.getText().toString(), phoneNumber.getText().toString());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    removeContact(userId, name.getText().toString(), phoneNumber.getText().toString());
            }
        });
    }

    void initData()
    {
        if(isEdit)
        {

            Query query =  contactDbRef.orderByChild("name").equalTo("John Doe");


            contactDbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    currenctContact = dataSnapshot.child(userId).getValue(Contact.class);

                    if(currenctContact != null) {
                        name.setText(currenctContact.name);
                        phoneNumber.setText(currenctContact.phoneNumber);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Authenticate First", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    // Add User
    private void writeNewUser(String Id, String name, String email) {
        Contact contact = new Contact(name, email, Id);

        if(isEdit)
        {
            contact.contactID = userId;
            contactDbRef.child(userId).setValue(contact);
        }
        else {
            contactDbRef.child(Id).setValue(contact);
        }

        onBackPressed();
    }

    private void removeContact(String userId, String name, String email){
        if(isEdit){
            contactDbRef.child(userId).removeValue();
        }
        onBackPressed();
    }
}
