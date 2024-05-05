package com.example.task.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.data.modal.CommenModalItem;
import com.example.task.databinding.LayoutCommentsListItemBinding;

import java.util.List;


public class CommentsAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public final List<CommenModalItem> dataList;

    public CommentsAdapter(List<CommenModalItem> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCommentsListItemBinding binding = LayoutCommentsListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CommenModalItem currentItem = dataList.get(position);

        holder.bind(currentItem.getName(), currentItem.getBody(), currentItem.getEmail());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }




}
