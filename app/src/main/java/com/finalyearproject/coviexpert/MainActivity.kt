package com.finalyearproject.coviexpert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= FirebaseAuth.getInstance()

        Registerbtn.setOnClickListener{
            var intent = Intent(this , RegisterActivity :: class.java)
            startActivity ( intent )
            finish()

        }

        loginEtn.setOnClickListener{

            if(checking()){
                val email=EmailAddress.text.toString()
                val password=Password.text.toString()
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    task->
                    if(task.isSuccessful)
                    {
                        var i = Intent(this , LoggedIn:: class.java)
                        i.putExtra("email",email)
                        startActivity(i)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this,"Wrong details",Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Enter the details",Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun checking() :Boolean
    {
        if(EmailAddress.text.toString().trim{it<=' '}.isNotEmpty() && Password.text.toString().trim{it<=' '}.isNotEmpty() ){
            return true
        }
        return false
    }
}