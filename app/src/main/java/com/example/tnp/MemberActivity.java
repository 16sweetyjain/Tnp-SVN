package com.example.tnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemberActivity extends AppCompatActivity {

  private Button post_btn;
  private Button comp_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
post_btn=findViewById(R.id.button_post);
comp_btn=findViewById(R.id.button_comp);
comp_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MemberActivity.this, ShowDoubts.class);
        startActivity(i);
    }
});
        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MemberActivity.this, PostUpdate.class);
                startActivity(i);
            }
        });
    }
}
