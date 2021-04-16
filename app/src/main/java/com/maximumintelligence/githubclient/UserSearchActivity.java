package com.maximumintelligence.githubclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UserSearchActivity extends AppCompatActivity {


    private EditText userName;
    private TextView responseTV;
    public Intent intent;
    public UserFinder userFinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_finder_activity);

        userName = findViewById(R.id.user_search);
        responseTV = findViewById(R.id.responseTV);


    }

    public void searchInit(View view) {
        userFinder = new UserFinder();
        userFinder.loadData(userName.getText().toString(), responseTV);


    }

    public void moreUserInfo(View view) {

        if (responseTV.getText() != "user not found") {
            intent = new Intent(UserSearchActivity.this, UserInfoActivity.class);
            intent.putExtra("username", userName.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "I don't know anything about this user", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}