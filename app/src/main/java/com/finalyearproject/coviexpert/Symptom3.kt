package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding
import com.finalyearproject.coviexpert.databinding.FragmentSymptom3Binding

class Symptom3:Fragment(R.layout.fragment_symptom3) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom3Binding.inflate(layoutInflater)
        val fragment3 = Symptom4()
        bind.nxt3.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment3, Symptom4::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev3=Symptom2()
        bind.p3.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev3, Symptom2::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y31.setOnClickListener{
            Attributes.sore_throat=1;
        }

        bind.n31.setOnClickListener{
            Attributes.sore_throat=0;
        }


        return bind.root
    }
}