package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salma.projek_kel5_xiipplg3.databinding.ActivityDashboard2Binding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityLoginBinding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityRegisterBinding

class dashboard2 : AppCompatActivity() {
    private lateinit var binding: ActivityDashboard2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboard2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sayangkuhh.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }

        binding.lopeee.setOnClickListener {
            startActivity(Intent(this, register::class.java))
        }
    }

}