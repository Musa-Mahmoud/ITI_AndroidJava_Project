package com.iti.oishi.model.remote.network;

public interface INetworkCallback<T> {
    void onSuccessfulResponse(T response);
    void onFailedResponse(String errorMsg);
}
