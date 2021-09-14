package com.himel.androiddeveloper3005.git.roomdatabase.fragmet.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.himel.androiddeveloper3005.git.roomdatabase.R
import com.himel.androiddeveloper3005.git.roomdatabase.model.User
import com.himel.androiddeveloper3005.git.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        userViewModel =  ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDataBAse()
        }
        return view
    }

    private fun insertDataToDataBAse() {
        val firstName = et_firstName.text.toString()
        val lastName = et_lastName.text.toString()
        val age = et_age.text

        if (inputCheck(firstName,lastName,age)){
            //create User Object
            val user = User(0,firstName,lastName,Integer.parseInt(age.toString()))
            //add user to database
            userViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully Added",Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(),"Please fill all fields!!",Toast.LENGTH_LONG).show()


        }


    }

    private fun inputCheck(firstName : String, lastName : String , age : Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }

}