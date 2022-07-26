package com.finalyearproject.coviexpert

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_logged_in.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

class LoggedIn : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        proceed.setOnClickListener {
            var intent = Intent(this, SymptomsActivity::class.java)
            startActivity(intent)
            finish()

        }

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        val isLogin = sharedPref.getString("email", "1")
        db = FirebaseFirestore.getInstance()


        if (isLogin == "1") {
            var email = intent.getStringExtra("email")
            if (email != null) {
                DemoName.setText("You are logged in")
                with(sharedPref.edit())
                {
                    putString("email", email)
                    apply()

                }
            } else {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        } else {
            DemoName.setText("You have been registered")

        }
    }
}

