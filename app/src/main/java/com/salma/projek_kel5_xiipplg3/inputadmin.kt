package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.salma.projek_kel5_xiipplg3.databinding.ActivityInputadminBinding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityInputcustomerBinding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityTampiladminBinding
import com.salma.projek_kel5_xiipplg3.db.admin
import com.salma.projek_kel5_xiipplg3.db.database

class inputadmin : AppCompatActivity() {
    private lateinit var binding: ActivityInputadminBinding
    private lateinit var Database: database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputadmin)
        binding = ActivityInputadminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            startActivity(Intent(this,ActivityTampiladminBinding::class.java))
        }

        binding.backInpadm.setOnClickListener {
            startActivity(Intent(this, dashboard::class.java))
        }
        Database = database.getInstances(applicationContext)
        binding.button3.setOnClickListener {
            if (binding.editTextTextPersonName7.text.isNotEmpty() &&
                binding.editTextTextPersonName15.text.isNotEmpty()
            ) {
                Database.DAOCustomer().Insertdataadmin(
                    admin(
                        0,
                        binding.editTextTextPersonName7.text.toString(),
                        binding.editTextTextPersonName15.text.toString()

                    )
                )
                binding.editTextTextPersonName7.setText("")
                binding.editTextTextPersonName15.setText("")
            }
            startActivity(
                Intent(this, tampiladmin::class.java)
            )
        }
    }
}
