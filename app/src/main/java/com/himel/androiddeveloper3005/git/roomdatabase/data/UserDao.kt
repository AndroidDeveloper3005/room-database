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

    //delete single user
    @Delete
    suspend fun deleteUser(user: User)

    //delete all user
    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    //read all data
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>
}