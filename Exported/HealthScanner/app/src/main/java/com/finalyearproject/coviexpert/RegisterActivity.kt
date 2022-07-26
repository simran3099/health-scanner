package com.finalyearproject.coviexpert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()

        Continue.setOnClickListener {
            if (checking()) {
                var emailid = email.text.toString()
                var pswd = pass.text.toString()
                var name = name.text.toString()
                var phone = pno.text.toString()
                val user = hashMapOf(
                    "Name" to name,
                    "Phone" to phone,
                    "email" to emailid
                )

                val Users = db.collection("USERS ")
                val query = Users.whereEqualTo("email", emailid).get()
                    .addOnSuccessListener { tasks ->
                        if (tasks.isEmpty) {
                            auth.createUserWithEmailAndPassword(emailid, pswd)
                                .addOnCompleteListener(this) { task ->
                                    if (task.isSuccessful) {
                                        Users.document(emailid).set(user)
                                        Toast.makeText(this, " User Added ", Toast.LENGTH_LONG)
                                            .show()
                                        val intent = Intent(this, MainActivity::class.java)
                                        intent.putExtra("email",emailid)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            " Authentication Failed ",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }

                        } else {
                            Toast.makeText(this, " User Already Registered ", Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
            }

              else {
                Toast.makeText(this ," Enter the Details ",Toast.LENGTH_LONG).show ()
            }
        }
    }

    private fun checking():Boolean{
        if(name.text.toString().trim{it<=' '}.isNotEmpty()
            && pno.text.toString().trim{it<=' '}.isNotEmpty()
            && email.text.toString().trim{it<=' '}.isNotEmpty()
            && pass.text.toString().trim{it<=' '}.isNotEmpty()){
            return true
        }
        return false
    }
}
