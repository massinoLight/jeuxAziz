package com.example.jeuxaziz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Resultat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat)
        val point = intent.getStringExtra("POINTS")

        val p : TextView =findViewById(R.id.points)

        p.setText("Félicitation vous avez eu "+point+" points")

    }
}
