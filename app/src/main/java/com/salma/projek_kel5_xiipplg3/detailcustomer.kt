package com.salma.projek_kel5_xiipplg3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.salma.projek_kel5_xiipplg3.databinding.ActivityDetailcustomerBinding
import com.salma.projek_kel5_xiipplg3.db.database

class detailcustomer : AppCompatActivity() {
    private lateinit var binding: ActivityDetailcustomerBinding
    private val db by lazy { database.getInstances(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityDetailcustomerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.leftIDetCus.setOnClickListener { onBackPressed() }
        var id = intent.getStringExtra("idcustomer").toString().toInt()
        val data = db.DAOCustomer().getDataIdCustomer(id)[0]
        val hasil = data.berat.toDouble() * data.harga.toString().toDouble()


        with(binding) {
            txtid.setText(data.id.toString())
            txtnama.setText(data.nama)
            txtalamat.setText(data.alamat)
            txtberatt.setText(data.berat)
            txttanggal.setText(data.tanggal)
            txtselesai.setText(data.selesai)
            txttotal.setText(hasil.toString())
        }

    }
}
