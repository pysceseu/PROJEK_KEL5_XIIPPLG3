package com.salma.projek_kel5_xiipplg3.db

import androidx.room.*

@Dao
interface DAOCustomer {
    //Customer
    @Insert
    fun Insertdatacustomer(vararg customer: customer)
    @Update
    fun Updatedatacustomer(vararg customer: customer)
    @Delete
    fun Deletedatacustomer(vararg customer: customer)
    @Query("SELECT * FROM tbCustomer")
    fun getdatacustomer() : List<customer>
    @Query("SELECT * FROM tbCustomer WHERE id_customer=:idCust")
    fun getDataIdCustomer(idCust: Int) : List<customer>

    //Admin
    @Insert
    fun Insertdataadmin(vararg admin: admin)
    @Update
    fun Updatedataadmin(vararg admin: admin)
    @Delete
    fun Deletedataadmin(vararg admin: admin)
    @Query("SELECT * FROM tbAdmin")
    fun getdataadmin() : List<admin>
    @Query("SELECT * FROM tbAdmin WHERE id_customer=:idAdm")
    fun getDataIdAdmin(idAdm: Int) : List<admin>


}