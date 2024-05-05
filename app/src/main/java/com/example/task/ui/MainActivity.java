package com.example.task.ui;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.task.R;
import com.example.task.adapter.CommentsAdapter;
import com.example.task.data.modal.CommenModalItem;
import com.example.task.databinding.ActivityMainBinding;
import com.example.task.utils.ItemTouchHelperAdapter;
import com.example.task.utils.SimpleItemTouchHelperCallback;
import com.example.task.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity implements ItemTouchHelperAdapter {

    ActivityMainBinding binding;
    private CommentsAdapter adapter;
    private MainViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialization();
    }

    private void initialization() {
        userViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.progrssbar.setVisibility(View.VISIBLE);
        userViewModel.getCommentsListLiveData().observe(this, new Observer<List<CommenModalItem>>() {
            @Override
            public void onChanged(List<CommenModalItem> value) {
                // Update UI with the new value
              //  textView.setText(value);
                binding.progrssbar.setVisibility(View.GONE);

                adapterSetup(value);

            }
        });
    }

    private void adapterSetup(List<CommenModalItem> value) {
       // userViewModel.
        adapter = new CommentsAdapter(value);
        binding.rvComments.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(binding.rvComments);
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(adapter.dataList, fromPosition, toPosition);
        adapter.notifyItemMoved(fromPosition, toPosition);

    }
}