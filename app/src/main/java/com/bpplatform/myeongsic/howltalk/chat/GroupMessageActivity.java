package com.bpplatform.myeongsic.howltalk.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bpplatform.myeongsic.howltalk.R;
import com.bpplatform.myeongsic.howltalk.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class GroupMessageActivity extends AppCompatActivity {
    Map<String,UserModel> users = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_message);

        FirebaseDatabase.getInstance().getReference().child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users = (Map<String, UserModel>) dataSnapshot.getValue();
                System.out.println(users.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
