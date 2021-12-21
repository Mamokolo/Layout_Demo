package com.example.layoutdemo.viewPager2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.layoutdemo.R;
import com.example.layoutdemo.bottomNavigation.DownloadFragment;
import com.example.layoutdemo.bottomNavigation.HomeFragment;
import com.example.layoutdemo.bottomNavigation.MusicFragment;
import com.example.layoutdemo.bottomNavigation.SettingFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPager2Activity extends FragmentActivity {
    private ViewPager2 viewPager2;
    private FragmentStateAdapter fragmentStateAdapter;
    private TabLayout tabLayout;
    private final ArrayList<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);

        tabLayout = findViewById(R.id.tab_demo);
        /* dynamic add */
//        for(int i=0;i<5;i++){
//            fragmentList.add(new MusicFragment());
//            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_music_note_24));
//        }
        /* static add */
        fragmentList.add(new HomeFragment());
        fragmentList.add(new DownloadFragment());
        fragmentList.add(new MusicFragment());
        fragmentList.add(new SettingFragment());
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_camera_alt_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_download_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_music_note_24));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_settings_24));

        viewPager2 = findViewById(R.id.vp2);
        fragmentStateAdapter = new SpecialAdapter(this, fragmentList);
        viewPager2.setAdapter(fragmentStateAdapter);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setPageTransformer(new PageTransformer());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }
}
