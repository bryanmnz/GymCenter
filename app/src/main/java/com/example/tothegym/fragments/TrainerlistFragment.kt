package com.example.tothegym.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tothegym.R
import com.example.tothegym.adapters.TrainerAdapter
import com.example.tothegym.dao.Trainer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GymlistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainerlistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_trainerlist, container, false);
        // Inflate the layout for this fragment
        var list = view.findViewById<RecyclerView>(R.id.list);
        var listTrainers = mutableListOf<Trainer>()
        listTrainers.add(Trainer("Tutulo Uno", "Subtitulo Uno","",""));
        listTrainers.add(Trainer("Tutulo Dos", "Subtitulo Dos","",""));
        listTrainers.add(Trainer("Tutulo Tres", "Subtitulo Tres","",""));
        listTrainers.add(Trainer("Tutulo Cuatro", "Subtitulo Cuatro","",""));
        list.adapter = TrainerAdapter(listTrainers);
        list.layoutManager = LinearLayoutManager(activity);
        return view;
    }


}
