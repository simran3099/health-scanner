package com.finalyearproject.coviexpert

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        Symptomsbtn.setOnClickListener {
            var intent = Intent(this , Result :: class.java)
            startActivity ( intent )
            finish()
        }
            val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return


            Logout.setOnClickListener{
                sharedPref.edit ( ).remove ("email" ).apply()
                Firebase.auth.signOut()
                var intent = Intent (this , MainActivity :: class.java )
                startActivity ( intent )
                finish ( )
            }

    }


    }
