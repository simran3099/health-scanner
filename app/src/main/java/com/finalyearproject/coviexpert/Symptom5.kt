package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom3Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom5Binding

class Symptom5:Fragment(R.layout.fragment_symptom5) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom5Binding.inflate(layoutInflater)
        val fragment5 = Symptom6()
        bind.nxt5.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment5, Symptom6::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev5=Symptom4()
        bind.p5.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev5, Symptom4::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y5.setOnClickListener{
            Attributes.headache=1;
        }

        bind.n5.setOnClickListener{
            Attributes.headache=0;
        }


        return bind.root
    }
}