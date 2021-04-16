package com.maximumintelligence.githubclient;


import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.maximumintelligence.api.Client;
import com.maximumintelligence.skeleton.UserSkeleton;
import com.maximumintelligence.api.GetUserInfo;

public class UserFinder {

    public void loadData(String username, TextView responseTV) {
        GetUserInfo apiService = Client.getApi().create(GetUserInfo.class);

        Call<UserSkeleton> call = apiService.getUser(username);
        call.enqueue(new Callback<UserSkeleton>() {

            @Override
            public void onResponse(Call<UserSkeleton> call, Response<UserSkeleton>
                    response) {

                try {
                    responseTV.setText("Found user: " + response.body().getLogin());


                } catch (Exception e) {

                    responseTV.setText("user not found");

                }
            }



            @Override
            public void onFailure(Call<UserSkeleton> call, Throwable t) {
                responseTV.setText("error");
            }
        });


    }


}
