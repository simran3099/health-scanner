package com.finalyearproject.coviexpert

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_logged_in.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

class LoggedIn : AppCompatActivity() {
    private lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        proceed.setOnClickListener{
            var intent = Intent(this , SymptomsActivity :: class.java)
            startActivity ( intent )
            finish()

        }

        val sharedPref = this?.getPreferences (Context.MODE_PRIVATE) ?: return
        val isLogin=sharedPref.getString("Email","1")
        db= FirebaseFirestore.getInstance()


        if(isLogin=="1") {
            var email = intent.getStringExtra("email")
            if (email != null) {
                setText(email)
                with(sharedPref.edit())
                {
                    putString("Email", email)
                    apply()

                }
            }
            else{
                var intent = Intent (this , MainActivity :: class.java )
                startActivity ( intent )
                finish ( )

            }
        }
        else
        {
            setText(isLogin)
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setText(email:String?)
    {
        db= FirebaseFirestore.getInstance()
        if (email != null) {
            db.collection("USERS").document(email).get()
                .addOnSuccessListener {
                        tasks->

                    DemoName.text = tasks.get(" Name ").toString()
                    phone.text = tasks.get(" Phone ").toString()
                    emailLog.text = tasks.get(" email ").toString()
                }
        }
    }
}
