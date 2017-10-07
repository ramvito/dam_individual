package com.example.horarios591;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class DestinationActivity extends AppCompatActivity {

    private ImageView scheduleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        this.scheduleImage = (ImageView) findViewById(R.id.scheduleImage);

        // Get the intent
        Intent intent = getIntent();
        String destination = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        showSchedule(destination);
    }

    private void showSchedule(String destination) {

        int resource = destination.equals(getString(R.string.destination_escuela)) ? R.drawable.sentido_fi : R.drawable.sentido_aluche;

        scheduleImage.setImageResource(resource);
    }
}
