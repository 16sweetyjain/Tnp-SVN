package com.example.tnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends AppCompatActivity {
private Button button_corp;
private Button see_upd;
private Button ask_but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        button_corp=findViewById(R.id.button_corp);

        ask_but=findViewById(R.id.button_ask);
        ask_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentActivity.this,DoubtsActivity.class);
                startActivity(i);
            }
        });
        see_upd=findViewById(R.id.button_see);
        see_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentActivity.this,UpdatedPost.class);
                startActivity(i);
            }
        });
        button_corp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent=new Intent(StudentActivity.this,CompaniesList.class);
                startActivity(new_intent);
            }
        });

    }
}
