package com.finalyearproject.coviexpert

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.finalyearproject.coviexpert.databinding.FragmentPredictionBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_symptoms.*
import kotlinx.android.synthetic.main.fragment_prediction.*
import org.json.JSONException
import org.json.JSONObject
import org.w3c.dom.Attr

class Prediction:Fragment(R.layout.fragment_prediction) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): RelativeLayout {

        var queue:RequestQueue = Volley.newRequestQueue(activity)
        val url = "https://covi-scan-app.herokuapp.com/predict";

        var sr = object:StringRequest(Method.POST, url, { response ->

            try {
                var jsonObject: JSONObject = JSONObject(response);
                var data: String = jsonObject.getString("Covid Prediction Report");
                if (data.equals("1.0")) {
                    Report.setText("According to our Prediction, You might be covid positive." +
                                " You are advised to consult the doctor");
                } else {
                    Report.setText(
                        "You have been found to be covid negative. If the symptoms persist longer," +
                                "you may consult the doctor"
                    )
                }
            } catch (e : JSONException) {
                e.printStackTrace();
            }

        }, { error ->
            Toast.makeText(activity, error.message, Toast.LENGTH_LONG).show()

        })
        {
            override fun getParams():MutableMap<String,String>{
                var map=HashMap<String,String>()
                map.put("cough", Attributes.cough.toString());
                map.put("fever", Attributes.fever.toString());
                map.put("sore_throat", Attributes.sore_throat.toString());
                map.put("shortness_of_breath", Attributes.shortness_of_breath.toString());
                map.put("headache", Attributes.headache.toString());
                map.put("age_60_and_above", Attributes.age_60_and_above.toString());
                map.put("gender", Attributes.gender.toString());
                map.put("test_indication", Attributes.test_indication.toString());

                return map;
            }
        }
        queue.add(sr);


        val bind = FragmentPredictionBinding.inflate(layoutInflater)
        bind.Details.setOnClickListener{
            var intent = Intent(this.requireContext(), DetailsActivity :: class.java)
            startActivity ( intent )


        }

        bind.signout.setOnClickListener {


                Firebase.auth.signOut()
                var intent = Intent (activity , MainActivity :: class.java )
                startActivity ( intent )

        }

        bind.back.setOnClickListener {

            var intent = Intent (activity , SymptomsActivity :: class.java )
            startActivity ( intent )

        }
        return bind.root
    }
}