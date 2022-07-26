package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom3Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom7Binding

class Symptom7:Fragment(R.layout.fragment_symptom7) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom7Binding.inflate(layoutInflater)
        val fragment7 = Symptom8()
        bind.nxt7.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment7, Symptom8::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev7=Symptom6()
        bind.p7.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev7, Symptom6::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y7.setOnClickListener{
            Attributes.gender=1;
        }

        bind.n7.setOnClickListener{
            Attributes.gender=0;
        }
        return bind.root
    }
}