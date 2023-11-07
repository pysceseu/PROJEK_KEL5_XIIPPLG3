package com.salma.projek_kel5_xiipplg3

import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salma.projek_kel5_xiipplg3.db.customer

class adapterCust (val list: ArrayList<customer>, var listener: OnClickListener)
    :RecyclerView.Adapter<adapterCust.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val id = itemView.findViewById<TextView>(R.id.txtIdCustAdp)
            val nama = itemView.findViewById<TextView>(R.id.txtNmCustAdp)
            val edit = itemView.findViewById<ImageView>(R.id.imgEditcus)
            val hapus = itemView.findViewById<ImageView>(R.id.imgHpscus)
            val detail = itemView.findViewById<TextView>(R.id.txtLhtDetail)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adaptercust,parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = list[position].id.toString()
        holder.nama.text = list[position].nama
        holder.edit.setOnClickListener{
            listener.onEdit(list[position])
        }
        holder.hapus.setOnClickListener {
            listener.onHapus(list[position])
        }
        holder.detail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, detailcustomer::class.java).putExtra("idCustomer", list[position].id.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: List<customer>){
        list.clear()
        list.addAll(newList)

    }

    interface OnClickListener{
        fun onEdit(customer: customer)
        fun onHapus(customer: customer)
    }
}