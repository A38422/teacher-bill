package com.example.teacherbill.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherbill.R
import com.example.teacherbill.model.Teacher

class TeacherAdapter(private val teachers: List<Teacher>) : RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.txtName.text = holder.txtName.text.toString() + teacher.tenGiaoVien
        holder.txtMa.text = holder.txtMa.text.toString() + teacher.maGiaoVien
        holder.txtDegree.text = holder.txtDegree.text.toString() + teacher.bangCap
        holder.txtCoefficient.text = holder.txtCoefficient.text.toString() + teacher.heSoGiaoVien.toString()
    }

    override fun getItemCount(): Int {
        return teachers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtMa: TextView = itemView.findViewById(R.id.txtMa)
        val txtDegree: TextView = itemView.findViewById(R.id.txtDegree)
        val txtCoefficient: TextView = itemView.findViewById(R.id.txtCoefficient)
    }
}