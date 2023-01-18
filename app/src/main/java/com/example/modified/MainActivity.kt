package com.example.modified

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, fragment1).commit()


    }


}