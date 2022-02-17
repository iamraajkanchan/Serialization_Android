package com.example.serialization_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer , firstFragment , "First Fragment").commit()
    }
}