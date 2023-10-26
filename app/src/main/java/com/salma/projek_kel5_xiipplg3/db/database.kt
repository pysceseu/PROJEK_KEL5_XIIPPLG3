package com.salma.projek_kel5_xiipplg3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [customer::class], version = 1)

abstract class database : RoomDatabase() {
    abstract fun DAOCustomer() : DAOCustomer

    companion object {

        @Volatile
        private var Instances: database? = null

        @Synchronized
        fun getInstances(context: Context): database {
            if (Instances == null) {
                Instances = Room.databaseBuilder(context,database::class.java, "My Laudry")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return Instances!!
        }
    }
}
