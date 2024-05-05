package com.example.task.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.data.modal.CommenModalItem;
import com.example.task.data.repo.MainRepositoryImpl;
import com.example.task.network.ResponseHandler;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MainRepositoryImpl mainRepository;
    private MutableLiveData<List<CommenModalItem>> commentListLiveData;

    public MainViewModel() {
        mainRepository = new MainRepositoryImpl();
        commentListLiveData = new MutableLiveData<>();
        fetchComments();
    }

    public LiveData<List<CommenModalItem>> getCommentsListLiveData() {
        return commentListLiveData;
    }

    public void fetchComments() {
        mainRepository.getComments(new ResponseHandler() {
            @Override
            public void success(List<CommenModalItem> data) {
                commentListLiveData.setValue( data);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
