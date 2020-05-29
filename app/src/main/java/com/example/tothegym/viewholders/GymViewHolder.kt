package com.example.tothegym.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.R
import com.example.tothegym.dao.Gym
import com.example.tothegym.dao.Trainer
import kotlinx.android.synthetic.main.card_gym.view.*

class GymViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title = itemView.title;
    var subTitle = itemView.subTitle;
    var rate = itemView.rate;
    fun bind(item: Gym){
        title.text=item.name;
        subTitle.text = item.city + " - " + item.address
        rate.numStars = item.rate.toInt();

    }
}