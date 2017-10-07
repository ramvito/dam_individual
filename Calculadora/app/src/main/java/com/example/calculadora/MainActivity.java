package com.example.calculadora;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';

    private char CURRENT_OPERRATION;

    private double value1 = Double.NaN;
    private double value2;

    private TextView display;

    private boolean cleanDisplay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.infoText);
        bindButtons();
    }

    private void bindButtons() {

        ((Button) findViewById(R.id.button0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "0");
            }
        });

        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "1");
            }
        });

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "2");
            }
        });

        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }
                display.setText(display.getText().toString() + "3");
            }
        });

        ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "4");
            }
        });

        ((Button) findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "5");
            }
        });

        ((Button) findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "6");
            }
        });

        ((Button) findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "7");
            }
        });

        ((Button) findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "8");
            }
        });

        ((Button) findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "9");
            }
        });

        ((Button) findViewById(R.id.button0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + "0");
            }
        });

        ((Button) findViewById(R.id.buttonDot)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleanDisplay) {
                    display.setText(null);
                    cleanDisplay = false;
                }

                display.setText(display.getText().toString() + ".");
            }
        });

        // OPERATORS
        ((Button) findViewById(R.id.buttonPlus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(null);
                CURRENT_OPERRATION = ADDITION;
            }
        });

        ((Button) findViewById(R.id.buttonMinus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(null);
                CURRENT_OPERRATION = SUBTRACTION;
            }
        });

        ((Button) findViewById(R.id.buttonTimes)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(null);
                CURRENT_OPERRATION = MULTIPLICATION;
            }
        });

        ((Button) findViewById(R.id.buttonDivision)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(null);
                CURRENT_OPERRATION = DIVISION;
            }
        });

        ((Button) findViewById(R.id.buttonEqual)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(Double.toString(value1));
                CURRENT_OPERRATION = '0';
            }
        });

        ((Button) findViewById(R.id.buttonEqual)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculate();
                display.setText(Double.toString(value1));
                CURRENT_OPERRATION = '0';
                value1 = Double.NaN;
                cleanDisplay = true;
            }
        });

        ((Button) findViewById(R.id.buttonClear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                display.setText(null);
                value1 = Double.NaN;
            }
        });
    }

    private void calculate() {

        if (!Double.isNaN(value1)) {

            value2 = Double.parseDouble(display.getText().toString());

            switch (CURRENT_OPERRATION) {

                case ADDITION:

                    value1 = value1 + value2;
                    break;

                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;

                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;

                case DIVISION:
                    value1 = value1 / value2;
                    break;

                default:
                    // Should not reach this point
            }

            display.setText(Double.toString(value1));

        } else {

            String displayContent = display.getText().toString();
            Log.i("INFO", displayContent);
            if (displayContent != "") {
                value1 = Double.parseDouble(displayContent);
            }
        }
    }
}
