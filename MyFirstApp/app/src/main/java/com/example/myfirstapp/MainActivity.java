package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init = false;

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String welcomeMsg;

                if (!init) {
                    welcomeMsg = "Hello world!";
                } else {
                    welcomeMsg = "Bye World!";
                }

                init = !init;

                TextView text = (TextView) findViewById(R.id.text1);
                text.setText(welcomeMsg);
            }
        });

    }
}
