package com.example.tothegym

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.dao.Gym

class GymAdapter(var items: List<Gym>) : RecyclerView.Adapter<GymViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_gym,parent, false);
        return GymViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: GymViewHolder, position: Int) {
        holder.bind(items[position]);
    }
}