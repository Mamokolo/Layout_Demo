package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.layoutdemo.bottomNavigation.BottomNavigationActivity;
import com.example.layoutdemo.recyclerView.RecyclerViewActivity;
import com.example.layoutdemo.viewPager2.ViewPager2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_vp2 = findViewById(R.id.btn_viewPager2);
        Button bt_bn = findViewById(R.id.btn_bottomNavigation);
        Button bt_rv = findViewById(R.id.btn_recyclerView);

        bt_bn.setOnClickListener(view ->{
            Intent it = new Intent(MainActivity.this, BottomNavigationActivity.class);
            startActivity(it);
        });
        bt_vp2.setOnClickListener(view ->{
            Intent it = new Intent(MainActivity.this, ViewPager2Activity.class);
            startActivity(it);
        });
        bt_rv.setOnClickListener(view ->{
            Intent it = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(it);
        });
    }
}