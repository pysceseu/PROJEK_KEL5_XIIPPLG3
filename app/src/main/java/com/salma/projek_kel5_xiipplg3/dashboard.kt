package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salma.projek_kel5_xiipplg3.databinding.ActivityDashboardBinding

class dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgLeft.setOnClickListener {
            startActivity(Intent(this, dashboard2::class.java))
        }

        binding.imgCustom.setOnClickListener {
            startActivity(Intent(this, inputcustomer::class.java))
        }

        binding.imgAdmin.setOnClickListener {
            startActivity(Intent(this, inputadmin::class.java))
        }
    }
}