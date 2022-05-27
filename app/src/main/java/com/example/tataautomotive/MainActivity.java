package com.example.tataautomotive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] subjects = new String[]{"english","hindi","urdu","english","hindi","urdu"}; //plug

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        RecyclerView subjectRecyclerView = findViewById(R.id.list_pane); //socket
        subjectRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //arrange the items one below the other
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(subjectRecyclerView.getContext(),
                new LinearLayoutManager(this).getOrientation());
        subjectRecyclerView.addItemDecoration(dividerItemDecoration);

        SubjectsAdapter adapter = new SubjectsAdapter(subjects); //putting the plug into the adapter
        subjectRecyclerView.setAdapter(adapter);
    }
}