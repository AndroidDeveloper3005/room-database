package com.himel.androiddeveloper3005.git.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.himel.androiddeveloper3005.git.roomdatabase.model.User

//for all database operation
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    //read all data
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>
}