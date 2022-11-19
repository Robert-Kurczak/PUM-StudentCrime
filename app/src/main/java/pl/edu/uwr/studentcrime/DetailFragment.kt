package pl.edu.uwr.studentcrime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val crime = DataProvider.crimeList[arguments?.getInt("ID")!!]

        val crimeTitle: TextView = view.findViewById(R.id.crime_title_details)
        val crimeResolvedImage: ImageView = view.findViewById(R.id.crime_resolved_image_details)
        val crimeStudentIndex: TextView = view.findViewById(R.id.crime_student_index_details)
        val crimeDescription: TextView = view.findViewById(R.id.crime_description_details)

        crimeTitle.text = crime.title
        if(crime.resolved){
            crimeResolvedImage.alpha = 0F
        }
        else{
            crimeResolvedImage.alpha = 1F
        }

        crimeStudentIndex.text = crime.studentIndex.toString()
        crimeDescription.text = crime.description
    }
}