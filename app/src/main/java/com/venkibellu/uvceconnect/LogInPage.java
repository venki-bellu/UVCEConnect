package com.venkibellu.uvceconnect;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LogInPage extends AppCompatActivity  {

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


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(homepageIntent);
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Facebook LogIn Cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }




}
