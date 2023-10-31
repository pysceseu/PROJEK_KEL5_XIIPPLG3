package com.salma.projek_kel5_xiipplg3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.salma.projek_kel5_xiipplg3.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username  = binding.inpUnmrgstr
        val email = binding.inpEmailrgstr
        val password =binding.inpPsswrdrgstr
        val confirmpassword = binding.inpConfirmpsswrd.text.split("\\s+".toRegex())

        binding.btnSimpan.setOnClickListener {
            if (username.text.isNotEmpty() && password.text.isNotEmpty()
                && email.text.isNotEmpty() && confirmpassword.isNotEmpty()) {
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
                alert("Semua data wajib diisi!")
            }
        }
    }
    private fun alert(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
    }
