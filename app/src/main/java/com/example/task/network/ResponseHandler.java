package com.example.task.network;

import com.example.task.data.modal.CommenModalItem;

import java.util.List;

public interface ResponseHandler {

    public void success(List<CommenModalItem> data);
    public void error(String error);

}
