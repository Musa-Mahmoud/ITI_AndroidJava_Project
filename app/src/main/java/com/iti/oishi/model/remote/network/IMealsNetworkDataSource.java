package com.iti.oishi.model.remote.network;

import retrofit2.Call;

public interface IMealsNetworkDataSource {
    <T> void makeNetworkCall(Call<T> call, INetworkCallback<T> networkCallback);
}
