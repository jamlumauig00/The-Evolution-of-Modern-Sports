package thee.jmc.theevolutionofmodernsports

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.Adapters.AdapterOnClick
import thee.jmc.theevolutionofmodernsports.Adapters.SecondAdapter
import thee.jmc.theevolutionofmodernsports.Adapters.ThirdAdapter
import thee.jmc.theevolutionofmodernsports.databinding.FragmentSecondBinding
class SecondFragment : Fragment(), AdapterOnClick {

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


    @SuppressLint("SetTextI18n")
    private fun loadData(position: Int) {
        val res: Resources = resources
        firstArray = res.getStringArray(R.array.firstpage)
        binding.TitleBar.text = firstArray[position]
        when(position){
            0 ->{
                rview.visibility = View.GONE
                binding.abouuuut.visibility = View.VISIBLE
                binding.abouuuut.text = getString(R.string.sports_description_paragraph_1) + "\n\n" + getString(R.string.sports_description_paragraph_2)
            }

            1 -> {
                title = res.getStringArray(R.array.milestones)
                description = res.getStringArray(R.array.descriptions)

                for (value in title) {
                    secondAdapter = SecondAdapter(title, description, requireContext())
                    rview.adapter = secondAdapter
                }
            }

            else ->{
                title = res.getStringArray(R.array.categories_sports)

                for (value in title) {
                    thirdAdapter = ThirdAdapter(title,this, requireContext())
                    rview.adapter = thirdAdapter
                }

            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onclick(position: Int) {
        val bundle = Bundle()
        bundle.putInt("POSITION", position) // Replace "POSITION" with your desired key
        findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment, bundle)
        Log.e ("dataposition---", position.toString())

    }
}