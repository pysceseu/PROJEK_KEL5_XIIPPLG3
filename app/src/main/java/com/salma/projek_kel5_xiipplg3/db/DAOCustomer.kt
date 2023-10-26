package com.salma.projek_kel5_xiipplg3.db

import androidx.room.*

@Dao
interface DAOCustomer {
    @Insert
    fun Insertdatacustomer(customer: customer)

    @Update
    fun Updatedatacustomer(customer: customer)

    @Delete
    fun Deletedatacustomer(customer: customer)

    @Query("SELECT * FROM tbCustomer")
    fun getdatacustomer() : List<customer>
}