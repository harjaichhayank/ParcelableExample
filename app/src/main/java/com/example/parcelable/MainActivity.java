package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener{

    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<Data> arrayList = new ArrayList<>();
    String[] texts,text2;

    int[] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_android_black};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerViewId);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        texts = getResources().getStringArray(R.array.Titles);
        text2 = getResources().getStringArray(R.array.SubTitles);

        int count=0;
        for (String text: texts){
            Data data = new Data(images[count],text,text2[count]);
            arrayList.add(data);
            count++;
        }
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(MainActivity.this);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("Data",arrayList.get(position));        //passed in the whole arrayList
        startActivity(intent);
    }
}
