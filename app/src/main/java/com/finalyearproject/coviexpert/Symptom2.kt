package com.finalyearproject.coviexpert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.finalyearproject.coviexpert.databinding.FragmentSymptom2Binding


class Symptom2:Fragment(R.layout.fragment_symptom2){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom2Binding.inflate(layoutInflater)
        val fragment2 = Symptom3()
        bind.nxt2.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragment2, Symptom3::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        val prev2=Symptom1()
        bind.p1.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, prev2, Symptom1::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y2.setOnClickListener {
            Attributes.fever=1;
        }
        bind.n2.setOnClickListener {
            Attributes.fever=0
        }
        return bind.root
    }

}