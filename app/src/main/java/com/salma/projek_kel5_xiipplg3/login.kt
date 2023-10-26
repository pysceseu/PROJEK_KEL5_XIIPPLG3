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
    private lateinit var find: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        find = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(find.root)

        val username = find.inpUnmlogin
        val password = find.inpPsswrdlogin
        val mimnimalpw = find.inpPsswrdlogin.text.split("\\s+".toRegex())


        find.btnlogin.setOnClickListener {

            if (username.text.isNotEmpty() && password.text.isNotEmpty()) {
                if (password.text.length >= 8) {
                    startActivity(
                        Intent(this, ActivityDashboard2Binding::class.java)
                            .putExtra("username", username.text.toString())
                    )
                    finish()
                    alert("Selamat datang di Go-Rent ${username.text}")
                    finish()


                }else {
                    alert("Pasword minimal 8 huruf")
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