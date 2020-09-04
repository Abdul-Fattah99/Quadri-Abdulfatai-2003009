package com.example.quadriabdulfatai2009003

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    var deliveries:MutableList<Deliveries> = ArrayList()
    lateinit var context:Context

    fun RecyclerAdapter(deliveries: MutableList<Deliveries>, context: Context){
        this.deliveries = deliveries
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int {
        return deliveries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = deliveries.get(position)
        holder.bind(item,context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //val operator = view.findViewById<TextView>(R.id.operator_type)
        val total_text = view.findViewById<TextView>(R.id.total)
        val total_value = view.findViewById<TextView>(R.id.total_value)
        val discharged_text = view.findViewById<TextView>(R.id.discharged)
        val discharged_value = view.findViewById<TextView>(R.id.discharged_value)
        val undischarged_text = view.findViewById<TextView>(R.id.undischarged)
        val undischarged_value = view.findViewById<TextView>(R.id.undischarged_value)

        fun bind(deliveries:Deliveries, context: Context){
                total_value.text = deliveries.Container.total.toString()
                // discharged_text.text = deliveries[i].
                discharged_value.text = deliveries.Container.discharged.toString()
                //undischarged_text.text = deliveries.discharged_text
                undischarged_value.text = deliveries.Container.not_discharged.toString()
                itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context,deliveries.message,Toast.LENGTH_SHORT).show() })

        }
    }

}

