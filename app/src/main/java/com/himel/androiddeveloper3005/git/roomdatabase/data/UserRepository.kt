package com.himel.androiddeveloper3005.git.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val  userDao: UserDao) {
    val readAlData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}