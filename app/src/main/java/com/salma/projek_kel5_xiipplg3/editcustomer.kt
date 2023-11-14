package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salma.projek_kel5_xiipplg3.databinding.ActivityEditcustomerBinding
import com.salma.projek_kel5_xiipplg3.db.customer
import com.salma.projek_kel5_xiipplg3.db.database

class editcustomer : AppCompatActivity() {
    private lateinit var binding: ActivityEditcustomerBinding
    private val db by lazy { database.getInstances(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditcustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("idCustomer").toString().toInt()
        val data = db.DAOCustomer().getDataIdCustomer(id)

        binding.inpNamaEdCust.setText(data[0].nama)
        binding.inpAlmEdCust.setText(data[0].alamat)
        binding.inpBeratEdCust.setText(data[0].berat)
        binding.inpTglEdCust.setText(data[0].tanggal)
        binding.inpTglSelesiEdCust.setText(data[0].selesai)

        binding.btnedtcust.setOnClickListener {

            if (binding.inpNamaEdCust.text.isNotEmpty()&&
                binding.inpAlmEdCust.text.isNotEmpty()&&
                binding.inpBeratEdCust.text.isNotEmpty()&&
                binding.inpHrgaEdCust.text.isNotEmpty()&&
                binding.inpTglEdCust.text.isNotEmpty()&&
                binding.inpTglSelesiEdCust.text.isNotEmpty()){

                db.DAOCustomer().Updatedatacustomer(customer(
                    id,
                    binding.inpNamaEdCust.text.toString(),
                    binding.inpAlmEdCust.text.toString(),
                    binding.inpBeratEdCust.text.toString(),
                    binding.inpHrgaEdCust.text.toString().toInt(),
                    binding.inpTglEdCust.text.toString(),
                    binding.inpTglSelesiEdCust.text.toString()
                ))

                Toast.makeText(applicationContext,"Data berhasil diubah", Toast.LENGTH_SHORT).show()
                startActivity(
                    Intent(this,tampilcustomer::class.java)
                )
                onBackPressed()
            }else{
                Toast.makeText(applicationContext,"Ubah data terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}