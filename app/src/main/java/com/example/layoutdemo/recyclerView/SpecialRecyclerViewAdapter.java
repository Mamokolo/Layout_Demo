package com.example.layoutdemo.recyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layoutdemo.R;
import com.example.layoutdemo.viewPager2.SpecialHolder;

import java.util.ArrayList;

public class SpecialRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<String> list;
    public SpecialRecyclerViewAdapter(ArrayList<String> list){
        this.list = list;
    }
    @NonNull
    /**
     *  建立 ViewHolder 的地方，如果有同時支援多種 layout 的需求，
     *  可以複寫 getItemViewType function，
     *  這個 function 就可以拿到不同的 viewType 以供我們識別。
     */
    @Override
    public SpecialHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpecialHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_holder,parent,false));
    }
     /**
      * 因為 ViewHolder 會重複使用
      * 我們要在這個 function 依據 position
      * 把正確的資料跟 ViewHolder 綁定在一起。
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
    /**
     * 回傳整個 Adapter 包含幾筆資料。
     */
    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
