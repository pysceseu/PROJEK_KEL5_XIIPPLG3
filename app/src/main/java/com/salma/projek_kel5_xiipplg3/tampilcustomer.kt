package com.salma.projek_kel5_xiipplg3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.salma.projek_kel5_xiipplg3.databinding.ActivityTampilcustomerBinding
import com.salma.projek_kel5_xiipplg3.db.customer
import com.salma.projek_kel5_xiipplg3.db.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampilcustomer : AppCompatActivity() {
    private val db by lazy { database.getInstances(this) }
    private lateinit var binding: ActivityTampilcustomerBinding
    private lateinit var adapter: adapterCust
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilcustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = adapterCust(arrayListOf(),
        object : adapterCust.OnClickListener {
            override fun onHapus(customer: customer) {
                hapusdataCus(customer)
            }

            override fun onEdit(customer: customer) {
                editdataCus(customer)
            }
        })

        binding.listdataCus.adapter= adapter
        binding.listdataCus.layoutManager= LinearLayoutManager(applicationContext, VERTICAL, false)
        binding.listdataCus.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        binding.imgaddcus.setOnClickListener {
            startActivity(Intent(this, inputcustomer::class.java))
        }


    }

    private fun hapusdataCus(customer: customer){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus Data")
            setMessage("Apakah anda yakin akan menghapus data ${customer.nama}?")
            setNegativeButton("Batal"){
                dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }

            setPositiveButton("Hapus"){
                dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.DAOCustomer().Deletedatacustomer(customer)
                    finish()
                    startActivity(intent)
                }
                getData()
            }
            dialog.show()
        }
    }

    private fun editdataCus(customer: customer){
        startActivity(Intent(this, editcustomer::class.java)
            .putExtra("id pesan", customer.id.toString()))
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        binding.listdataCus.layoutManager= LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.DAOCustomer().getdatacustomer()
            adapter.setData(data)
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
        binding.listdataCus.adapter= adapter
    }
}