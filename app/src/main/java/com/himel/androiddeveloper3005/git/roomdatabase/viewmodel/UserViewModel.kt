package com.himel.androiddeveloper3005.git.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.himel.androiddeveloper3005.git.roomdatabase.data.UserDatabase
import com.himel.androiddeveloper3005.git.roomdatabase.repository.UserRepository
import com.himel.androiddeveloper3005.git.roomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//act as communication center between repository and ui
class UserViewModel(application: Application) : AndroidViewModel(application){
    val readAllData : LiveData<List<User>>
    private val repository : UserRepository
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAlData
    }

    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)

        }
    }

    fun  updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun  deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun  deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }


}