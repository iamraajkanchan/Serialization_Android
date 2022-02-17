package com.example.serialization_android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment()
{
    private lateinit var mContext : MainActivity
    private lateinit var person : Person
    override fun onAttach(context : Context)
    {
        super.onAttach(context)
        mContext = context as MainActivity
    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    {
        person = arguments?.getSerializable("Person_Object") as Person
        return inflater.inflate(R.layout.fragment_second , container , false)
    }

    override fun onStart()
    {
        super.onStart()
        tvFirstName.text = person.firstName
        tvLastName.text = person.lastName
    }
}