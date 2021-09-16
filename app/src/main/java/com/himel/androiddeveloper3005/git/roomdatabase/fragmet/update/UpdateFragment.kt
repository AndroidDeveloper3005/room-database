package com.himel.androiddeveloper3005.git.roomdatabase.fragmet.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.himel.androiddeveloper3005.git.roomdatabase.R
import com.himel.androiddeveloper3005.git.roomdatabase.model.User
import com.himel.androiddeveloper3005.git.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.update_firstName_et.setText(args.currentUser.firstName)
        view.et_update_lastName.setText(args.currentUser.lastName)
        view.et_update_age.setText(args.currentUser.age.toString())
        view.update_btn.setOnClickListener {
            updateItem()

        }
        //add menu
        setHasOptionsMenu(true)

        return view
    }

    fun updateItem(){
        val firstName = update_firstName_et.text.toString()
        val lastName = et_update_lastName.text.toString()
        val age = Integer.parseInt(et_update_age.text.toString())

        if (inputCheck(firstName , lastName , et_update_age.text)){
            //create user object
            val updateUser =  User(args.currentUser.id , firstName , lastName , age)

            // update current user
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(),"Successfully Updated", Toast.LENGTH_LONG).show()


            // navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)


        }else{
            Toast.makeText(requireContext(),"Please fill all fields!!",Toast.LENGTH_LONG).show()

        }


    }


    private fun inputCheck(firstName : String, lastName : String , age : Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu , menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete_menu){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,_ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),
                    "Successfully Removed ${args.currentUser.firstName}",
                    Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)


        }
        builder.setNegativeButton("No"){ _,_ ->


        }

        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}")
        builder.create().show()
    }
}