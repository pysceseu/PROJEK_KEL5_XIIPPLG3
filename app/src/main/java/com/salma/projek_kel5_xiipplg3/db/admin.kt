package com.salma.projek_kel5_xiipplg3.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbAdmin")
data class admin(
    @PrimaryKey
    @ColumnInfo(name = "nama_admin")
    val namaAdmin: String,
    @ColumnInfo(name = "nama_customer")
    val namaCustomer: String
)
