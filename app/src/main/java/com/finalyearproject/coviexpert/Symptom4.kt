package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom3Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom4Binding

class Symptom4:Fragment(R.layout.fragment_symptom4) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom4Binding.inflate(layoutInflater)
        val fragment4 = Symptom5()
        bind.nxt4.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment4, Symptom5::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev4=Symptom3()
        bind.p4.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev4, Symptom3::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y4.setOnClickListener{
            Attributes.shortness_of_breath=1;
        }

        bind.n4.setOnClickListener{
            Attributes.shortness_of_breath=0;
        }


        return bind.root
    }
}