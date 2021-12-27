package com.example.layoutdemo.recyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layoutdemo.R;

import java.util.ArrayList;

public class SpecialRecyclerViewAdapter extends RecyclerView.Adapter<SpecialRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "SpecialAdapter";
    private final ArrayList<String> list;

    public SpecialRecyclerViewAdapter(ArrayList<String> list){
        this.list = list;
    }
    @NonNull
    /**
     *  建立 ViewHolder 的地方，如果有同時支援多種 layout 的需求，
     *  可以複寫 getItemViewType function，
     *  這個 function 就可以拿到不同的 viewType 以供我們識別。
     */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_holder,parent,false));
    }
     /**
      * 因為 ViewHolder 會重複使用
      * 我們要在這個 function 依據 position
      * 把正確的資料跟 ViewHolder 綁定在一起。
     */
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(list.get(position));
        holder.getDelete().setOnClickListener(view -> {
            list.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,list.size()-position);
            Log.i(TAG, list.toString());
        });
        holder.getDuplicate().setOnClickListener(view -> {
            //Log.i(TAG,position+" : "+list.get(position));
            list.add(position+1,list.get(position));
            notifyItemInserted(position+1);//注意這裡
            //这里刷新了从添加的position到最后的Item（注意这里的notifyItemRangeChanged第二个参数是count）
            if (position < list.size() - 1) {
                notifyItemRangeChanged(position, list.size() - position);
            }
            Log.i(TAG, list.toString());
        });
    }
    /**
     * 回傳整個 Adapter 包含幾筆資料。
     */
    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        private final Button delete, duplicate;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.textView_holder);
            delete = (Button) view.findViewById(R.id.btn_delete);
            duplicate = (Button) view.findViewById(R.id.btn_duplicate);
        }
        public TextView getTextView() {
            return textView;
        }
        public Button getDelete(){
            return delete;
        }
        public Button getDuplicate(){
            return duplicate;
        }
    }
}
