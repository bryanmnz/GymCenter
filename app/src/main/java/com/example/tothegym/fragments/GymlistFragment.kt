package com.example.tothegym.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tothegym.adapters.GymAdapter

import com.example.tothegym.R
import com.example.tothegym.dao.Gym
import com.example.tothegym.network.api.APIService
import com.example.tothegym.network.api.RetrofitInstance
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

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

    lateinit var adapter: GymAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_gymlist, container, false);
        // Inflate the layout for this fragment
        var list = view.findViewById<RecyclerView>(R.id.list);

        adapter = GymAdapter(mutableListOf());
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        loadContent();
        return view;
    }

    fun loadContent(){
        doAsync {
            val call = RetrofitInstance().getInstance().create(APIService::class.java).listGym(0,10).execute()
            uiThread {
                if(call.isSuccessful){
                    var gymResponse = call.body();
                    if (gymResponse != null) {
                        adapter.items.addAll(gymResponse.body)
                        adapter.notifyDataSetChanged()
                    }
                }else{
                    Toast.makeText(activity, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
