package com.salma.projek_kel5_xiipplg3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [customer::class, admin::class], version =3 )

abstract class database : RoomDatabase() {
    abstract fun DAOCustomer() : DAOCustomer

    companion object {

        @Volatile
        private var Instances: database? = null

        @Synchronized
        fun getInstances(context: Context): database {
            if (Instances == null) {
                Instances = Room.databaseBuilder(context,database::class.java, "My Laundry")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return Instances!!
        }
    }
}
