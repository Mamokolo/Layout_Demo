package com.example.layoutdemo.viewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class SpecialAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;

    // Give nothing => Create a new ArrayList with empty data set
    public SpecialAdapter(@NonNull FragmentActivity fa) {
        super(fa);
        if(fragments == null){
            fragments = new ArrayList<>();
        }
    }
    // Give a ArrayList of Fragment => Use the ArrayList as data set
    public SpecialAdapter(@NonNull FragmentActivity fa, ArrayList<Fragment> fragments){
        super(fa);
        if(this.fragments==null){
            this.fragments = new ArrayList<>();
        }
        else{
            this.fragments.clear();
        }
        this.fragments.addAll(fragments);
    }
    // Give a Fragment => put the Fragment as the first Fragment
    public SpecialAdapter(@NonNull FragmentActivity fa, Fragment fragment){
        super(fa);
        if(fragments == null){
            this.fragments = new ArrayList<>();
        }
        else{
            this.fragments.clear();
        }
        this.fragments.add(fragment);
    }

    public void addFragments(Fragment fragment){
        if(fragments!=null){
            fragments.add(fragment);
        }
    }
    public void cleanFragments(){
        if(!fragments.isEmpty()){
            fragments.clear();
            notifyDataSetChanged();
        }
    }
    public void deleteFragments(Fragment fragment){
        if(!fragments.isEmpty()){
            fragments.remove(fragment);
        }
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
