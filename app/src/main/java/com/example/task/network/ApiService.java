package com.example.task.network;


import com.example.task.data.modal.CommenModalItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("comments")
    Call<List<CommenModalItem>> getComments();
}
