package com.example.task.data.repo;

import static com.example.task.App.apiService;

import com.example.task.data.modal.CommenModalItem;
import com.example.task.network.ResponseHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepositoryImpl {
    public void getComments(ResponseHandler responseHandler) {
        try {
            Call<List<CommenModalItem>> call = apiService.getComments();
            call.enqueue(new Callback<List<CommenModalItem>>() {
                @Override
                public void onResponse(Call<List<CommenModalItem>> call, Response<List<CommenModalItem>> response) {
                    if (response.isSuccessful()) {
                        responseHandler.success(response.body());
                    } else {
                        responseHandler.error(response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<CommenModalItem>> call, Throwable t) {
                    responseHandler.error(t.getMessage());

                }
            });
        } catch (Exception e) {

        }
    }
}
