package com.example.tothegym.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.viewholders.TrainerViewHolder
import com.example.tothegym.R
import com.example.tothegym.dao.Trainer

class TrainerAdapter(var items: List<Trainer>): RecyclerView.Adapter<TrainerViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_trainer,parent, false);
        return TrainerViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: TrainerViewHolder, position: Int) {
        holder.bind(items[position]);
    }
}