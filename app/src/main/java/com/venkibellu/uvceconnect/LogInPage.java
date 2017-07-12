package com.venkibellu.uvceconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LogInPage extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    Intent homepageIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        homepageIntent = new Intent(this, HomePage.class);
        loginButton = (LoginButton) findViewById(R.id.fb_login_button);
        callbackManager = CallbackManager.Factory.create();


        if (isLoggedIn()) {
            startActivity(homepageIntent);
        }

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(homepageIntent);
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Facebook Login Cancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(getApplicationContext(), "Facebook Login Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }


    // if already logged in accessToken will not be null
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

}
