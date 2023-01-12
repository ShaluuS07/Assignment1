package com.example.newfrags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newfrags.MyFragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnOpenFragment : Button = findViewById(R.id.btn_openHomeFragment)
        val textviewfragment : TextView = findViewById(R.id.text_View)
        BtnOpenFragment.setOnClickListener {
            val homeFragment = HomeFragment()
            val fragment : Fragment? =
                supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

            if(fragment !is HomeFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.container_fragment,homeFragment,HomeFragment::class.java.simpleName)
                    .commit()

            }
            BtnOpenFragment.visibility = View.GONE
            textviewfragment.visibility = View.GONE

        }
    }
}