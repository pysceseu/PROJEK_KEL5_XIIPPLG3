package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.salma.projek_kel5_xiipplg3.databinding.ActivityDashboard2Binding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityDashboardBinding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityLoginBinding
import com.salma.projek_kel5_xiipplg3.databinding.ActivityRegisterBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.inpUnmlogin
        val password = binding.inpPsswrdlogin

        binding.btnlogin.setOnClickListener {

            if (username.text.isNotEmpty() && password.text.isNotEmpty()) {
                if (password.text.length >= 8) {
                    startActivity(
                        Intent(this, dashboard::class.java)
                            .putExtra("username", username.text.toString())
                    )
                    finish()
                    alert("Selamat datang di My Laundry ${username.text}")
                    finish()


                }else {
                    alert("Password minimal 8 huruf")
                }

            }else {
                alert("Username dan Password tidak boleh kosong!")
            }
        }
    }
    private fun alert(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}