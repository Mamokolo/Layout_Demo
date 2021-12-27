package com.example.layoutdemo.recyclerView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layoutdemo.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        for(int i = 0; i<10 ; i++) {
            list.add(String.valueOf(i));
        }
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        SpecialRecyclerViewAdapter srva = new SpecialRecyclerViewAdapter(list);
        recyclerView.setAdapter(srva);
        // 2nd para : 垂直/水平顯示, 3rd para : 正/倒序
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
