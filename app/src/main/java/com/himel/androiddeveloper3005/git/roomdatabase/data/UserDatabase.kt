package com.himel.androiddeveloper3005.git.roomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//contain the database holder and serves as the main access point for
// underlying connection to your apps persisted , relational data
@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE : UserDatabase ?= null

        fun getDatabase(context: Context) : UserDatabase {
            val tempInstenc = INSTANCE
            if (tempInstenc !=null){
                return tempInstenc
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"

                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}