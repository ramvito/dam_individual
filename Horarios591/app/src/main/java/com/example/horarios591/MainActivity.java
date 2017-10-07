package com.example.horarios591;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    Button alucheButton;
    Button escuelaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alucheButton = (Button) findViewById(R.id.aluche_button);
        escuelaButton = (Button) findViewById(R.id.escuela_button);

        alucheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(getString(R.string.destination_aluche));
            }
        });

        escuelaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(getString(R.string.destination_escuela));
            }
        });

    }

    /** Called when the user selects a destination */
    public void sendMessage(String destination) {

            Intent intent = new Intent(this, DestinationActivity.class);
            intent.putExtra(EXTRA_MESSAGE, destination);

            startActivity(intent);
    }
}
