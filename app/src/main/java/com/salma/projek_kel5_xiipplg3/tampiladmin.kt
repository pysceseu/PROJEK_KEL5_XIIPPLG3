package com.salma.projek_kel5_xiipplg3

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.salma.projek_kel5_xiipplg3.databinding.ActivityTampiladminBinding
import com.salma.projek_kel5_xiipplg3.db.admin
import com.salma.projek_kel5_xiipplg3.db.customer
import com.salma.projek_kel5_xiipplg3.db.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class tampiladmin : AppCompatActivity() {
    private val db by lazy { database.getInstances(this) }
    private lateinit var binding: ActivityTampiladminBinding
    private lateinit var adapter: adapterAdmin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampiladminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = adapterAdmin(arrayListOf(),
        object : adapterAdmin.OnClickListener {
            override fun onDelete(admin: admin) {
                hapusdataAdm(admin)
            }

            override fun onEdit(admin: admin) {
                editdataAdm(admin)
            }
        })

        binding.listdataAdm.adapter= adapter
        binding.listdataAdm.layoutManager= LinearLayoutManager(applicationContext, VERTICAL, false)
        binding.listdataAdm.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        binding.imgaddadm.setOnClickListener {
            startActivity(Intent(this, inputadmin::class.java))
        }
    }

    private fun hapusdataAdm(admin: admin){
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus Data")
            setMessage("Apakah anda yakin akan menghapus data ${admin.namaAdmin}?")
            setNegativeButton("Batal"){
                dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }

            setPositiveButton("Hapus"){
                dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.DAOCustomer().Deletedataadmin(admin)
                    finish()
                    startActivity(intent)
                }
                getData()
            }
            dialog.show()
        }
    }

    private fun editdataAdm(admin: admin){
        startActivity(Intent(this, edit_admin::class.java)
            .putExtra("idadmin", admin.namaAdmin))
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        binding.listdataAdm.layoutManager= LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.DAOCustomer().getdataadmin()
            adapter.setData(data)
            withContext(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
        binding.listdataAdm.adapter= adapter
    }
}