package thee.jmc.theevolutionofmodernsports

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.Adapters.Adapter
import thee.jmc.theevolutionofmodernsports.Adapters.AdapterOnClick
import thee.jmc.theevolutionofmodernsports.R
import thee.jmc.theevolutionofmodernsports.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), AdapterOnClick {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private var arraylist: Array<String> = arrayOf()
    private lateinit var rview: RecyclerView
    private lateinit var Sadapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        initialize()
        rview = binding.buttonsRview
        rview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        loadData()
        return binding.root
    }

    private fun initialize() {
        val top_curve_anim = AnimationUtils.loadAnimation(context, R.anim.top_down)
        binding.topCurve.startAnimation( top_curve_anim)

        val field_name_anim = AnimationUtils.loadAnimation(context, R.anim.field_name_anim)
        binding.logo.startAnimation(field_name_anim)
    }

    private fun loadData() {
        val res: Resources = resources
        arraylist = res.getStringArray(R.array.firstpage)

        for (value in arraylist) {
            Sadapter = Adapter(arraylist, this, requireContext())
            rview.adapter = Sadapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onclick(position: Int) {
        Log.e("POSITION", position.toString())

        val bundle = Bundle()
        bundle.putInt("POSITION", position) // Replace "POSITION" with your desired key
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }
}