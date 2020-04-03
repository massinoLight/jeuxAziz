package com.example.jeuxaziz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var difficulte=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val facile: CheckBox = findViewById(R.id.facile)
        val moyen: CheckBox =findViewById(R.id.moyen)
        val difficile: CheckBox =findViewById(R.id.difficil)
        val mortel: CheckBox =findViewById(R.id.mortel)



        facile.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                moyen.setChecked(false)
                difficile.setChecked(false)
                mortel.setChecked(false)
                difficulte=1

            }
        }

        moyen.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                facile.setChecked(false)
                difficile.setChecked(false)
                mortel.setChecked(false)
                difficulte=2

            }
        }

        difficile.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                moyen.setChecked(false)
                facile.setChecked(false)
                mortel.setChecked(false)
                difficulte=3

            }
        }


        mortel.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                moyen.setChecked(false)
                difficil.setChecked(false)
                facile.setChecked(false)
                difficulte=3

            }
        }


        continuer.setOnClickListener {

            if (difficulte==0){

                Toast.makeText(this,"Indiquez la difficulté svp",Toast.LENGTH_SHORT).show()

            }else
            {

                val intent2 = Intent(this, JeuxTimer::class.java)
                intent2.putExtra("difficulte",difficulte )
                startActivity(intent2)

            }

                }



    }
}
