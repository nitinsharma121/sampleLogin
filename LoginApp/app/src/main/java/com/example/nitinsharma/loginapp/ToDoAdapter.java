package com.example.nitinsharma.loginapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nitin sharma on 07-Dec-18.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    Context context;
    ArrayList<ItemsBean> arrayList=new ArrayList<>();
    ItemsBean itemsBean;

    public ToDoAdapter(Context context, ArrayList<ItemsBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v=LayoutInflater.from(context).inflate(R.layout.listitem,null,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ViewHolder holder, int position) {
        ItemsBean itemsBean=arrayList.get(position);
        holder.title.setText(itemsBean.getTitle());
        holder.description.setText(itemsBean.getDescription());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,description;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.subtitle);
            checkBox=itemView.findViewById(R.id.checkbox);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){

                    }

                }
            });
        }
    }
}
