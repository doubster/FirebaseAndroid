package com.example.doubea.firebasekitchensink.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.doubea.firebasekitchensink.Models.Contact;
import com.example.doubea.firebasekitchensink.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListActivity extends AppCompatActivity {


    @BindView(R.id.activity_contact_list_listview)
    ListView listView;

    @BindView(R.id.activity_contact_list_add_button)
    Button  addContactButton;


    private FirebaseDatabase database;
    private DatabaseReference contactDbRef;
    final List<Contact> contacts =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ButterKnife.bind(this);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();

        contactDbRef = database.getReference("contacts");



        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContactListActivity.this, EditContactActivity.class));
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent myIntent = new Intent(ContactListActivity.this, EditContactActivity.class);
                myIntent.putExtra("userID", contacts.get(position).contactID);
                myIntent.putExtra("IsEdit",true);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    void initData()
    {
        final ArrayList<String> contactNames = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactNames);
        listView.setAdapter(adapter);

        contactDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                contacts.clear();

                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    contacts.add(ds.getValue(Contact.class));
                }

                for (Contact c:contacts) {
                    contactNames.add(c.name);
                }


                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                String a = "Hello";
            }
        });


    }
}
