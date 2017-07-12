package com.venkibellu.uvceconnect;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class IntroductionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_screen);

        Handler handler=new Handler();
        final Intent intent=new Intent(this,LogInPage.class);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(intent);
                finish();
            }
        },3000);

    }


}
