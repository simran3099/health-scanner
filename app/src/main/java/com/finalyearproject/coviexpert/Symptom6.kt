package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom3Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom6Binding

class Symptom6:Fragment(R.layout.fragment_symptom6) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom6Binding.inflate(layoutInflater)
        val fragment6 = Symptom7()
        bind.nxt6.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment6, Symptom7::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev6=Symptom5()
        bind.p6.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev6, Symptom5::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y6.setOnClickListener {
            Attributes.age_60_and_above=1;
        }
        bind.n6.setOnClickListener {
            Attributes.age_60_and_above=0
        }
        return bind.root
    }
}