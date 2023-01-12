package com.example.newfrags.MyFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newfrags.R
import com.example.newfrags.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = FragmentHomeBinding.inflate(layoutInflater)
        val fragment1 = Fragment1()
        bind.btnOpenSecondFragment.setOnClickListener {
           fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_fragment, fragment1 , Fragment1::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()



            }
        }
        return bind.root
    }
}