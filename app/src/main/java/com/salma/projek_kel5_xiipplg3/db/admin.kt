package com.salma.projek_kel5_xiipplg3.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "tbAdmin")
data class admin(
    @ColumnInfo(name = "nama_admin")
    val namaAdmin: String,
    @ColumnInfo(name = "nama_customer")
    val namaCustomer: String
)
