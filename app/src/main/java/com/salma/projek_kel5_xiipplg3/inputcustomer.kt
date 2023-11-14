package com.salma.projek_kel5_xiipplg3

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.salma.projek_kel5_xiipplg3.databinding.ActivityInputcustomerBinding
import com.salma.projek_kel5_xiipplg3.db.customer
import com.salma.projek_kel5_xiipplg3.db.database
import java.text.SimpleDateFormat
import java.util.*

class inputcustomer : AppCompatActivity() {
    private lateinit var binding: ActivityInputcustomerBinding
    private lateinit var Database: database
    private lateinit var berat: EditText
    private lateinit var harga: EditText
    private lateinit var hasil: TextView
    private lateinit var kali: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputcustomer)
        binding = ActivityInputcustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        berat = findViewById(R.id.inpBeratt)
        harga = findViewById(R.id.inpHargaa)
        hasil = findViewById(R.id.HasilInp)
        kali = findViewById(R.id.imgKali)

        binding.imgKali.setOnClickListener {
            val hitung = berat.text.toString().toDouble() * harga.text.toString().toDouble()
            hasil.text = hitung.toString()
        }

        Database = database.getInstances(applicationContext)
        binding.leftInpCus.setOnClickListener {
            startActivity(Intent(this, dashboard::class.java))
        }
        binding.btninpcust.setOnClickListener {
            if (binding.inpNamacus.text.isNotEmpty() &&
                binding.inpAlamatcus.text.isNotEmpty() &&
                binding.inpBeratt.text.isNotEmpty() &&
                binding.inpHargaa.text.isNotEmpty() &&
                binding.inpTgl.text.isNotEmpty() &&
                binding.inpTglSelesai.text.isNotEmpty()
            ) {
                Database.DAOCustomer().Insertdatacustomer(
                    customer(
                        0,
                        binding.inpNamacus.text.toString(),
                        binding.inpAlamatcus.text.toString(),
                        binding.inpBeratt.text.toString(),
                        binding.inpHargaa.text.toString().toInt(),
                        binding.inpTgl.text.toString(),
                        binding.inpTglSelesai.text.toString()
                    )
                )

                binding.inpNamacus.setText("")
                binding.inpAlamatcus.setText("")
                binding.inpBeratt.setText("")
                binding.inpHargaa.setText("")
                binding.inpTgl.setText("")
                binding.inpTglSelesai.setText("")

                startActivity(
                    Intent(this, tampilcustomer::class.java)
                )
            }
        }
        this.setTanggalRegister()
        this.setTanggalSelesai()
    }
    private fun setTanggalRegister() {
        this.setTanggal()
        binding.inpTgl.setOnClickListener {
            var cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { picker, tahun, bulan, tanggal ->
                    binding.inpTgl.setText("" + tanggal + "-" + bulan + "-" + tahun)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
    private fun setTanggal () {
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("d-M-yyyy")
        val dateTime = simpleDateFormat.format(calendar.time)
        binding.inpTgl.setText(dateTime)
    }

    private fun setTanggalSelesai() {
        this.setTanggal2()
        binding.inpTglSelesai.setOnClickListener {
            var cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { picker, tahun, bulan, tanggal ->
                    binding.inpTglSelesai.setText("" + tanggal + "-" + bulan + "-" + tahun)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
    private fun setTanggal2 () {
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("d-M-yyyy")
        val dateTime = simpleDateFormat.format(calendar.time)
        binding.inpTglSelesai.setText(dateTime)
    }

}



