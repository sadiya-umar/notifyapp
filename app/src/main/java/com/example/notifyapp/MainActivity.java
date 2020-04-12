package com.example.notifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ocm.example.notifyapp.R;

public class MainActivity extends AppCompatActivity {
    private TextView MsgTxt;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getreference();
    private DatabaseReference mChildReference = mRootReference.Child("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MsgTxt=(TextView)findViewById(R.id.msgTxt);
        MsgTxt.setText("Message Appear Here...");
    }
    @Override
    protected void onStart(){
        super.onStart();
        mChildReference.addvalueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                String message = dataSnapshot.getValue(String.class);
                MsgTxt.setText(message);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
            )};
    }
}
