package com.example.tothegym

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.dao.Gym
import kotlinx.android.synthetic.main.card_gym.view.*

class GymViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title = itemView.title;
    var subTitle = itemView.subTitle;
    fun bind(item: Gym){
        title.text=item.title;
        subTitle.text = item.subTitle;
    }
}