package com.example.tnp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDoubts extends AppCompatActivity {
    private ListView listOfDoubts;
    private DatabaseReference mRef;
    private List<String> showDoubts;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doubts);

        listOfDoubts = findViewById(R.id.list);

        showDoubts = new ArrayList<>();
        mRef = FirebaseDatabase.getInstance().getReference().child("doubts");
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, showDoubts);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showDoubts.clear();
                for (DataSnapshot postSnap : dataSnapshot.getChildren()) {
                    //ModelPost new_post=postSnap.getValue(ModelPost.class);
                    String val = postSnap.getValue(String.class);
                    showDoubts.add(val);
                }
                //   CustomPostListAdapter adapter=new CustomPostListAdapter(UpdatedPost.this,allPosts);
                listOfDoubts.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("TAG", "Failed to read value.", databaseError.toException());
            }
        });
    }
}
