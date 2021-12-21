package com.example.layoutdemo.bottomNavigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.layoutdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
    private static final String TAG = "BN Msg";
    private HomeFragment homeFragment;
    private DownloadFragment downloadFragment;
    private MusicFragment musicFragment;
    private SettingFragment settingFragment;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNv);
        bottomNavigationView.setSelectedItemId(R.id.nav1);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (bottomNavigationView.getSelectedItemId() != item.getItemId()) {
                switch (item.getItemId()) {
                    case R.id.nav1:
                        Log.i(TAG,"First");
                        if (!jumpTo(0)) {
                            Toast.makeText(this, "Jump Failed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav2:
                        if (!jumpTo(1)) {
                            Toast.makeText(this, "Jump Failed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav3:
                        if (!jumpTo(2)) {
                            Toast.makeText(this, "Jump Failed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav4:
                        if (!jumpTo(3)) {
                            Toast.makeText(this, "Jump Failed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
            return true;
        });
        jumpTo(0);
    }

    private boolean jumpTo(int fragmentNum){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(R.anim.nav_default_enter_anim,R.anim.nav_default_exit_anim,R.anim.nav_default_pop_enter_anim,R.anim.nav_default_pop_exit_anim);
        hideFragment(transaction);
        switch (fragmentNum){
            case 0:
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_fragment,homeFragment);
                }
                else {
                    homeFragment.load();
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if(downloadFragment == null){
                    downloadFragment = new DownloadFragment();
                    transaction.add(R.id.fl_fragment,downloadFragment);
                }
                else {
                    downloadFragment.load();
                    transaction.show(downloadFragment);
                }
                break;
            case 2:
                if(musicFragment == null){
                    musicFragment = new MusicFragment();
                    transaction.add(R.id.fl_fragment,musicFragment);
                }
                else {
                    musicFragment.load();
                    transaction.show(musicFragment);
                }
                break;
            case 3:
                if(settingFragment == null){
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.fl_fragment,settingFragment);
                }
                else {
                    settingFragment.load();
                    transaction.show(settingFragment);
                }
                break;
            default:
                break;
        }
        try {
            transaction.commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    private void hideFragment(FragmentTransaction transaction){
        if(homeFragment != null){
            transaction.hide(homeFragment);
        }
        if(downloadFragment != null){
            transaction.hide(downloadFragment);
        }
        if(musicFragment != null){
            transaction.hide(musicFragment);
        }
        if(settingFragment != null){
            transaction.hide(settingFragment);
        }
    }
}
