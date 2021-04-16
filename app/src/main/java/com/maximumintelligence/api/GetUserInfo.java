package com.maximumintelligence.api;

import com.maximumintelligence.skeleton.UserSkeleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetUserInfo {

    @GET("/users/{user}")
    Call<UserSkeleton> getUser(@Path("user") String user);

    @GET("/users/{user}")
    Call<List<UserSkeleton>> getUserInfo(@Path("user") String user);
}
