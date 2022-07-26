package com.finalyearproject.coviexpert

import android.gesture.Prediction
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom8Binding

class Symptom8:Fragment(R.layout.fragment_symptom8) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom8Binding.inflate(layoutInflater)
        val fragment8 = Prediction()
        bind.submit.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment8, Prediction::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev8=Symptom7()
        bind.p8.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev8, Symptom7::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y8.setOnClickListener{
            Attributes.test_indication=3;
        }

        bind.n8.setOnClickListener{
            Attributes.test_indication=2;
        }

        bind.others.setOnClickListener{
            Attributes.test_indication=1;
        }
        return bind.root
    }
}