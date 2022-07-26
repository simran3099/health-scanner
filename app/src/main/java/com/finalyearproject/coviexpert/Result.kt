package com.finalyearproject.coviexpert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val homeFragment = Symptom1()
        val fragment: Fragment? =
            supportFragmentManager.findFragmentByTag(Symptom1::class.java.simpleName)
        if (fragment !is Symptom1) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fragmentContainerView,
                    homeFragment,
                    Symptom1::class.java.simpleName
                ).commit()


        }
    }
}