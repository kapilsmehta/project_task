package com.example.task.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.task.databinding.LayoutCommentsListItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

        private final LayoutCommentsListItemBinding binding;

        public MyViewHolder(LayoutCommentsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    public void bind(String name, String body, String email) {
        binding.commentsName.setText(name);
        binding.commentsBody.setText(body);
        binding.commentsEmail.setText(email);

    }
    }