package com.example.parsingxml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_row.view.*

class StudentAdapter (private val myStudents: ArrayList<Students>):  RecyclerView.Adapter<StudentAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val list1 =myStudents[position]

        holder.itemView.apply {
            tvName.text = list1.name
            tvGrade.text = list1.grade.toString()
        }
    }

    override fun getItemCount() = myStudents.size
}