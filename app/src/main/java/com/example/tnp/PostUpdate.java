package com.example.tnp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostUpdate extends AppCompatActivity {
private Button post_btn;
private EditText title;
private EditText description;
private String mTitle;
private String mDesc;
private DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_update);

mRef=FirebaseDatabase.getInstance().getReference("posts");
    post_btn=findViewById(R.id.button_post);

description=findViewById(R.id.desc);








    post_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
               addPost(); // add new post to databse
          //  Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();

        }
    });
    }

private void addPost(){
        //mRef.push();
   // mTitle=title.getText().toString();
    mDesc=description.getText().toString();
   // new_upd=new ModelPost(mTitle,mDesc); //Creating new model post object
   String id=mRef.push().getKey();
        mRef.child(id).setValue(mDesc);


        //set new post for current user


}
}
