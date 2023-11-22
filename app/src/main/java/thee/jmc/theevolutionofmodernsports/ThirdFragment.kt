package thee.jmc.theevolutionofmodernsports

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.Adapters.AdapterOnClick
import thee.jmc.theevolutionofmodernsports.Adapters.SecondAdapter
import thee.jmc.theevolutionofmodernsports.Adapters.ThirdAdapter
import thee.jmc.theevolutionofmodernsports.databinding.FragmentSecondBinding
class ThirdFragment : Fragment(), AdapterOnClick {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var firstArray: Array<String> = arrayOf()

    private var title: Array<String> = arrayOf()
    private var description: Array<String> = arrayOf()
    private lateinit var rview: RecyclerView
    private lateinit var secondAdapter: SecondAdapter
    private lateinit var thirdAdapter: ThirdAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val data = arguments?.getInt("POSITION")
        if (data != null) {
            Log.e ("data---", data.toString())
            //binding.textviewSecond.text =  data.toString()
            rview = binding.recycler
            rview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            loadData(data)
        }
        return binding.root
    }


    private fun loadData(position: Int) {
        val res: Resources = resources
        firstArray = res.getStringArray(R.array.categories_sports)
        binding.TitleBar.text = firstArray[position]

        when(position){
            0 ->{
                title = res.getStringArray(R.array.team_sports)
                description = res.getStringArray(R.array.team_sports_definitions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }

            1 -> {
                title = res.getStringArray(R.array.individual_sports)
                description = res.getStringArray(R.array.individual_sports_definitions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }
            2 -> {
                title = res.getStringArray(R.array.combat_sports)
                description = res.getStringArray(R.array.combat_sports_definitions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }
            3 -> {
                title = res.getStringArray(R.array.racing_sports)
                description = res.getStringArray(R.array.racing_sports_definitions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }

            else ->{
                title = res.getStringArray(R.array.target_sports)
                description = res.getStringArray(R.array.target_sports_definitions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onclick(position: Int) {
        TODO("Not yet implemented")
    }
}