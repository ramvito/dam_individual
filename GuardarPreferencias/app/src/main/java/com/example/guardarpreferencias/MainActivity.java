package com.example.guardarpreferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String preferencesFile = "myPreferences";
    final String preferencesKey = "myMessage";

    Button saveButton;
    Button loadButton;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.save_button);
        loadButton = (Button) findViewById(R.id.load_button);

        text = (TextView) findViewById(R.id.text1);

        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = text.getText().toString();
                SharedPreferences.Editor sharedPreferences = getSharedPreferences(preferencesFile, MODE_PRIVATE).edit();

                sharedPreferences.putString(preferencesKey, message).commit();
            }
        });

        loadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(preferencesFile, MODE_PRIVATE);

                String text = sharedPreferences.getString(preferencesKey, "No message");
                showToast(getApplicationContext(), text, Toast.LENGTH_SHORT);
            }
        });
    }

    /* Create a toast and show the saved message */
    private void showToast(Context context, String text, int duration) {

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
