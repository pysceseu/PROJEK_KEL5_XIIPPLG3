package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salma.projek_kel5_xiipplg3.databinding.ActivityInputcustomerBinding
import com.salma.projek_kel5_xiipplg3.db.admin
import com.salma.projek_kel5_xiipplg3.db.customer
import com.salma.projek_kel5_xiipplg3.db.database

class inputcustomer : AppCompatActivity() {
    private lateinit var binding: ActivityInputcustomerBinding
    private lateinit var Database: database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputcustomer)
        binding=ActivityInputcustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
//tggrtyg
        Database = database.getInstances(applicationContext)
        binding.button5.setOnClickListener {
            if (binding.inpNamacus.text.isNotEmpty() &&
                binding.inpAlamatcus.text.isNotEmpty()&&
                binding.inpKeterangan.text.isNotEmpty()&&
                binding.inpBerat.text.isNotEmpty()&&
                binding.inpHarga.text.isNotEmpty()&&
                binding.inpTgl.text.isNotEmpty()&&
                binding.inpTglSelesai.text.isNotEmpty()
            ){
                Database.DAOCustomer().Insertdatacustomer(
                    customer( 0,
                        binding.button5.text.toString(),
                        binding.inpAlamatcus.text.toString(),
                        binding.inpKeterangan.text.toString(),
                        binding.inpBerat.text.toString(),
                        binding.inpHarga.text.toString().toInt(),
                        binding.inpTgl.text.toString(),
                        binding.inpTglSelesai.text.toString()
                    )
                )

                binding.inpNamacus.setText("")
                binding.inpAlamatcus.setText("")
                binding.inpKeterangan.setText("")
                binding.inpBerat.setText("")
                binding.inpHarga.setText("")
                binding.inpTgl.setText("")
                binding.inpTglSelesai.setText("")

                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            }
        }
    }
}