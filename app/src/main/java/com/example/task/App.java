package com.example.task;

import android.app.Application;

import com.example.task.network.ApiClient;
import com.example.task.network.ApiService;

public class App extends Application {

    public  static ApiService apiService;
    @Override
    public void onCreate() {
        super.onCreate();
        apiService = ApiClient.getClient().create(ApiService.class);

    }
}
