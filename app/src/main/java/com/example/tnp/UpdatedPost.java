package com.example.tnp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdatedPost extends AppCompatActivity {
private ListView listOfPosts;
private DatabaseReference mRef;
private List<String>allPosts;

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_post);




        listOfPosts=findViewById(R.id.list_post);

        allPosts=new ArrayList<>();
        mRef= FirebaseDatabase.getInstance().getReference().child("posts");

      // uid=mRef.getKey();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,allPosts);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                allPosts.clear();
               for(DataSnapshot postSnap:dataSnapshot.getChildren()) {
                   //ModelPost new_post=postSnap.getValue(ModelPost.class);
                   String val=postSnap.getValue(String.class);
                    allPosts.add(val);
                }
             //   CustomPostListAdapter adapter=new CustomPostListAdapter(UpdatedPost.this,allPosts);
                listOfPosts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
}
