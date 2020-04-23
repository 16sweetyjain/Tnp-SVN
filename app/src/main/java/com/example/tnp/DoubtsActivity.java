package com.example.tnp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoubtsActivity extends AppCompatActivity {
private EditText post;
private String doubt;
private Button post_btn;
private Button contact;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubts);
        post=findViewById(R.id.doubt_text);
        post_btn=findViewById(R.id.ask_btn);
        contact=findViewById(R.id.contact_btn);

        mRef= FirebaseDatabase.getInstance().getReference("doubts");
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDoubt();
            }
        });


    }
    public void addDoubt(){
        doubt=post.getText().toString();
        String id=mRef.push().getKey();
        mRef.child(id).setValue(doubt);
    }
}
