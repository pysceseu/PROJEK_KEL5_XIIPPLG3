package com.salma.projek_kel5_xiipplg3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.salma.projek_kel5_xiipplg3.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {
    private lateinit var find : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        find = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(find.root)
        val username  = find.inpUnmrgstr
        val email = find.inpEmailrgstr
        val password =find.inpPsswrdrgstr
        val confirmpassword = find.inpConfirmpsswrd.text.split("\\s+".toRegex())
        setContentView(R.layout.activity_register)

        find.btnSimpan.setOnClickListener {

        }
    }
}