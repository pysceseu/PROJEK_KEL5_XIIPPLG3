package com.salma.projek_kel5_xiipplg3

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salma.projek_kel5_xiipplg3.db.admin

class adapterAdmin (val list: ArrayList<admin>, var listener: OnClickListener)
    : RecyclerView.Adapter<adapterAdmin.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idAdm = itemView.findViewById<TextView>(R.id.txtIdAdmAdp)
            val namaAdm = itemView.findViewById<TextView>(R.id.txtNmAdmAdp)
            val hapusAdm = itemView.findViewById<ImageView>(R.id.imgHps)
            val editAdm = itemView.findViewById<ImageView>(R.id.imgEdit)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapteradmin, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idAdm.text = list[position].namaAdmin
        holder.namaAdm.text = list[position].namaCustomer

        holder.hapusAdm.setOnClickListener {
            listener.onDelete(list[position])
        }
        holder.editAdm.setOnClickListener {
            listener.onEdit(list[position])
        }
    }
    fun setData(newList: List<admin>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListener {
        fun onDelete(admin: admin)
        fun onEdit(admin: admin)
    }
}