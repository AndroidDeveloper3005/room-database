package com.himel.androiddeveloper3005.git.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.himel.androiddeveloper3005.git.roomdatabase.data.UserDao
import com.himel.androiddeveloper3005.git.roomdatabase.model.User

class UserRepository(private val  userDao: UserDao) {
    val readAlData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}