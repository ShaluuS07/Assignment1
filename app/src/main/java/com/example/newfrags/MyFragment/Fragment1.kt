package com.example.newfrags.MyFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newfrags.R
import com.example.newfrags.SecondActivity
import com.example.newfrags.databinding.Fragment1Binding


class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = Fragment1Binding.inflate(layoutInflater)
        bind.openSecondActivity.setOnClickListener {
         val intent = Intent(this@Fragment1.requireContext(),SecondActivity::class.java)
            startActivity(intent)
        }
        return bind.root
    }


}

