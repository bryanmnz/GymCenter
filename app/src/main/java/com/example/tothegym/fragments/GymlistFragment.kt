package com.example.tothegym.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.GymAdapter
import com.example.tothegym.HomeActivity

import com.example.tothegym.R
import com.example.tothegym.dao.Gym

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GymlistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GymlistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_gymlist, container, false);
        // Inflate the layout for this fragment
        var list = view.findViewById<RecyclerView>(R.id.list);
        var listGym = mutableListOf<Gym>()
        listGym.add(Gym("Tutulo Uno", "Subtitulo Uno","",""));
        listGym.add(Gym("Tutulo Dos", "Subtitulo Dos","",""));
        listGym.add(Gym("Tutulo Tres", "Subtitulo Tres","",""));
        listGym.add(Gym("Tutulo Cuatro", "Subtitulo Cuatro","",""));
        list.adapter = GymAdapter(listGym);
        list.layoutManager = LinearLayoutManager(activity);
        return view;
    }


}
