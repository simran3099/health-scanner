package com.finalyearproject.coviexpert


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.finalyearproject.coviexpert.databinding.FragmentSymptom1Binding

class Symptom1:Fragment(R.layout.fragment_symptom1) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentSymptom1Binding.inflate(layoutInflater)
        val fragment1 = Symptom2()
        bind.nxt1.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.fragmentContainerView,
                    fragment1,
                    Symptom2::class.java.simpleName
                )
                    .addToBackStack(null)
                    .commit()
            }
        }

        bind.y11.setOnClickListener {
            Attributes.cough=1;
        }
        bind.n11.setOnClickListener {
            Attributes.cough=0
        }

                return bind.root
            }
        }

