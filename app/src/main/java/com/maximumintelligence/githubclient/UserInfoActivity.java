package com.maximumintelligence.githubclient;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maximumintelligence.adapter.Adapter;
import com.maximumintelligence.api.Client;
import com.maximumintelligence.api.GetUserInfo;
import com.maximumintelligence.skeleton.UserSkeleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends AppCompatActivity {

    Bundle receivedIntent;
    String receivedString;

    RecyclerView recyclerView;
    List<UserSkeleton> receivedUserdata = new ArrayList<>();
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity);

        receivedIntent = getIntent().getExtras();
        receivedString = receivedIntent.getString("username");

        recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(receivedUserdata, R.layout.user_info_list, getApplicationContext());

        recyclerView.setAdapter(adapter);
        loadExtendedData();
    }

    public void loadExtendedData() {
        GetUserInfo apiService = Client.getApi().create(GetUserInfo.class);

        Call<UserSkeleton> call = apiService.getUser(receivedString);
        call.enqueue(new Callback<UserSkeleton>() {

            @Override
            public void onResponse(Call<UserSkeleton> call, Response<UserSkeleton>
                    response) {

                receivedUserdata.clear();
                receivedUserdata.add(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UserSkeleton> call, Throwable t) {
                t.getMessage();
            }
        });


    }


}
