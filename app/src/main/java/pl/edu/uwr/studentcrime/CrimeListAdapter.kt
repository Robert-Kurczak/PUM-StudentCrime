package pl.edu.uwr.studentcrime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

open class CrimeListAdapter(private val context: Context, private val crimeList: List<Crime>)
    : RecyclerView.Adapter<CrimeListAdapter.CrimeListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeListViewHolder {
        return CrimeListViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.crimes_list_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int){
        val currentCrime: Crime = crimeList[position]
        holder.crimeTitle.text = currentCrime.title
        holder.crimeStudentIndex.text = currentCrime.studentIndex.toString()

        if(crimeList[position].resolved){
            holder.crimeResolvedImage.alpha = 0F
        }
        else{
            holder.crimeResolvedImage.alpha = 1F
        }

        holder.itemView.setOnClickListener{ view ->
            val bundle = bundleOf("ID" to position)

            view.findNavController().navigate(R.id.detailFragment, bundle)
        }
    }

    override fun getItemCount() = crimeList.size

    class CrimeListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val crimeTitle: TextView = view.findViewById(R.id.crime_title)
        val crimeStudentIndex: TextView = view.findViewById(R.id.crime_student_index)
        val crimeResolvedImage: ImageView = view.findViewById(R.id.crime_resolved_image)
    }
}