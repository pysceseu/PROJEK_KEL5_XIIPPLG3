package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salma.projek_kel5_xiipplg3.databinding.ActivityEditAdminBinding
import com.salma.projek_kel5_xiipplg3.db.admin
import com.salma.projek_kel5_xiipplg3.db.database

class edit_admin : AppCompatActivity() {

    private lateinit var binding: ActivityEditAdminBinding
    private val db by lazy { database.getInstances(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val nama = intent.getStringExtra("nmadmin").toString() //menerima nama
            val data = db.DAOCustomer().getDatanamaAdmin(nama)

            binding.edtNamaadmin.setText(data[0].namaAdmin)
            binding.edtNamacus.setText(data[0].namaCustomer)

            binding.btnSimpanEdadmin.setOnClickListener {

                if (binding.edtNamaadmin.text.isNotEmpty() &&
                    binding.edtNamacus.text.isNotEmpty()
                ) {

                    db.DAOCustomer().Updatedataadmin(
                        admin(
                            binding.edtNamaadmin.text.toString(),
                            binding.edtNamacus.text.toString()
                        )
                    )

                    Toast.makeText(applicationContext, "Data berhasil diubah", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(
                        Intent(this, tampiladmin::class.java)
                    )
                    onBackPressed()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Ubah data terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
