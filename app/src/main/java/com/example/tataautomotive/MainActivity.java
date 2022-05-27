package com.example.tataautomotive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String[] subjects = new String[]{"english","hindi","urdu","english","hindi","urdu"}; //plug
    public static String TAG = MainActivity.class.getSimpleName();
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

        adapter.setOnItemClickListener(new SubjectsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.d(TAG, "onItemClick position: " + position);

            }
        });

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(viewPagerAdapter);

    }
}