package com.example.tothegym.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.dao.Gym
import com.example.tothegym.dao.Trainer
import kotlinx.android.synthetic.main.card_gym.view.*

class TrainerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title = itemView.title;
    var subTitle = itemView.subTitle;
    fun bind(item: Trainer){
        title.text=item.title;
        subTitle.text = item.subTitle;
    }
}