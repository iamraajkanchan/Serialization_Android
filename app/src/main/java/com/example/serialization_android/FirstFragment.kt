package com.example.serialization_android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() , View.OnClickListener
{
    private lateinit var mContext : MainActivity

    override fun onAttach(context : Context)
    {
        super.onAttach(context)
        mContext = context as MainActivity
    }

    override fun onCreateView(
        inflater : LayoutInflater , container : ViewGroup? , savedInstanceState : Bundle?
    ) : View?
    {
        return inflater.inflate(R.layout.fragment_first , container , false)
    }

    override fun onStart()
    {
        super.onStart()
        btnNextScreen.setOnClickListener(this)
    }

    override fun onClick(view : View?)
    {
        if (view?.id == R.id.btnNextScreen)
        {
            if (edtFirstName.text.toString().isNotEmpty() && edtLastName.text.toString()
                    .isNotEmpty()
            )
            {
                val person = Person(edtFirstName.text.toString() , edtLastName.text.toString())
                val bundle = Bundle().apply {
                    putSerializable("Person_Object" , person)
                }
                val secondFragment = SecondFragment()
                secondFragment.arguments = bundle
                val transaction = mContext.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer , secondFragment , "Second Fragment")
                    .commit()
                transaction.addToBackStack("First Fragment")
            } else if (edtFirstName.text.toString().isEmpty())
            {
                edtFirstName.error = "First Name can't be blank!!!"
            } else if (edtLastName.text.toString().isEmpty())
            {
                edtLastName.error = "Last Name can't be blank!!!"
            }
        }
    }
}