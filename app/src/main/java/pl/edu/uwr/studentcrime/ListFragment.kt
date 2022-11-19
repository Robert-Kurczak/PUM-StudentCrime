package pl.edu.uwr.studentcrime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlin.random.Random
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?){
        super.onViewCreated(itemView, savedInstanceState)

        itemView.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = CrimeListAdapter(itemView.context, DataProvider.crimeList as MutableList<Crime>)
            layoutManager = LinearLayoutManager(itemView.context)
        }
    }
}