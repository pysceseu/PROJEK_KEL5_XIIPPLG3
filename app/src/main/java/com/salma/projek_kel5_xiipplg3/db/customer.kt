package com.salma.projek_kel5_xiipplg3.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbCustomer")
data class customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_customer")
    val id: Int,
    @ColumnInfo(name = "nama_customer")
    val nama: String,
    @ColumnInfo(name = "alamat_customer")
    val alamat: String,
    @ColumnInfo(name = "keterangan")
    val keterangan: String,
    @ColumnInfo(name = "berat")
    val berat: String,
    @ColumnInfo(name = "harga")
    val harga: Int,
    @ColumnInfo(name = "tanggal")
    val tanggal: String,
    @ColumnInfo(name = "selesai")
    val selesai: String
)
