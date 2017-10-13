package com.example.interfazcontroles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button botonEnviar;
    EditText numeroTarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonEnviar = (Button) findViewById(R.id.botonEnviar);
        botonEnviar.setEnabled(false);

        numeroTarjeta = (EditText) findViewById(R.id.numeroTarjeta);

        numeroTarjeta.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (!event.isShiftPressed()) {

                                // codigo para validar el numero de tarjeta proporcionado
                                botonEnviar.setEnabled(true);

                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                });
    }
}
