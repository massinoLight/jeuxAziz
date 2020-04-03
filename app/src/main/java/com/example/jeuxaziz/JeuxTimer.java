package com.example.jeuxaziz;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;

public class JeuxTimer extends AppCompatActivity {


    private TextView mTextViewCountDown;

    private TextView nombre1;
    private TextView nombre2;
    private TextView operation;
    private TextView points;
    private Button valider;
    private EditText reponse;

    Random r = new Random();


    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private boolean suivant=false;

    private long mTimeLeftInMillis;
    private int valeurMin;
    private int valeurMax;
    private int lavaleur1 = 10;
    private int lavaleur2 = 5;
    private int loperation = 0;
    private int leresultat;
    private int valeuroperationmax;
    private int point = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        nombre1 = findViewById(R.id.nombre1);
        nombre2 = findViewById(R.id.nombre2);

        operation = findViewById(R.id.operation);
        valider = findViewById(R.id.valider);
        reponse = findViewById(R.id.reponse);
        points = findViewById(R.id.points);


        points.setText(point + "");
        Intent intent = getIntent();
        int dificulte = intent.getIntExtra("difficulte", 1);
        switch (dificulte) {
            case 1: {
                mTimeLeftInMillis = 180000;
                valeurMax = 10;
                valeurMin = 0;
                valeuroperationmax = 1;
                break;
            }

            case 2: {
                mTimeLeftInMillis = 300000;
                valeurMax = 50;
                valeurMin = 0;
                valeuroperationmax = 2;
                break;
            }
            case 3: {
                mTimeLeftInMillis = 420000;
                valeurMax = 100;
                valeurMin = -100;
                valeuroperationmax = 3;
                break;
            }
            case 4: {
                mTimeLeftInMillis = 480000;
                valeurMax = 100;
                valeurMin = -100;
                valeuroperationmax = 3;
                break;
            }

        }


        startTimer();
        updateCountDownText();


            jouer();


    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                //ici lancer le resultat

            }
        }.start();

        mTimerRunning = true;

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

    }

    private void resetTimer() {
        mTimeLeftInMillis = 300000;
        updateCountDownText();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }


    private void jouer() {


       // while ((mTimerRunning)) {
            suivant=false;

            //while (!suivant) {
                lavaleur1 = valeurMin + r.nextInt(valeurMax - valeurMin);
            lavaleur2 = valeurMin + r.nextInt(valeurMax - valeurMin);
            loperation = r.nextInt(valeuroperationmax - 0);


            switch (loperation) {
                case 0: {
                    nombre1.setText(lavaleur1 + "");
                    nombre2.setText(lavaleur2 + "");
                    operation.setText("+");
                    leresultat = lavaleur1 + lavaleur2;
                    break;
                }
                case 1: {
                    nombre1.setText(lavaleur1 + "");
                    nombre2.setText(lavaleur2 + "");
                    operation.setText("-");
                    leresultat = lavaleur1 - lavaleur2;
                    break;
                }

                case 2: {
                    nombre1.setText(lavaleur1 + "");
                    nombre2.setText(lavaleur2 + "");
                    operation.setText("X");
                    leresultat = lavaleur1 * lavaleur2;
                    break;
                }
                case 3: {
                    nombre1.setText(lavaleur1 + "");
                    nombre2.setText(lavaleur2 + "");
                    operation.setText("/");
                    leresultat = lavaleur1 / lavaleur2;
                    break;
                }
                default:
                    // code block
            }


            valider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (Integer.parseInt(reponse.getText().toString()) == leresultat) {
                        point = point + 10;
                        Log.e("ikchem", "athan gel if");
                        points.setText(point + "");
                        suivant=true;

                    } else {

                        point = point - 1;
                        Log.e("ikchem", "athan gel else");
                        points.setText(point + "");
                        suivant=true;
                    }

                }


            });

        //}


    //}

}




}