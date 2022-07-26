package com.finalyearproject.coviexpert

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        Symptomsbtn.setOnClickListener {
            var intent = Intent(this, Symptom1::class.java)
            startActivity(intent)
            val sharedPref = this?.getPreferences (Context.MODE_PRIVATE)?: return@setOnClickListener

            Logout.setOnClickListener{
                sharedPref.edit ( ).remove ("Email" ).apply()
                var intent = Intent (this , MainActivity :: class.java )
                startActivity ( intent )
                finish ( )
            }
        }
    }
}