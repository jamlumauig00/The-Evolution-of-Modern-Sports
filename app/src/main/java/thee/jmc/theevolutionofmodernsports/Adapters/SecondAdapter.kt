package thee.jmc.theevolutionofmodernsports.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.R

class SecondAdapter(
    var mainlist: Array<String>,
    var description: Array<String>,
    val context: Context
) :
    RecyclerView.Adapter<SecondAdapter.ViewHolder>() {
    var currentposition = 0


    class ViewHolder(v: View, val context: Context) : RecyclerView.ViewHolder(v) {
        private val title: TextView = v.findViewById(R.id.second_title)
        private val desc: TextView = v.findViewById(R.id.second_description)

        fun bindIdea(dataTitle: String, dataDesc: String) {
            title.text = dataTitle
            desc.text = dataDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.secondlayout, parent, false
        ), context
    )

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mainlist[position]
        val desc = description[position]

        holder.bindIdea(data, desc)
        val descS: TextView = holder.itemView.findViewById(R.id.second_description)

        descS.visibility = View.GONE

        if (currentposition == position) {
            descS.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener()
        {
            currentposition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }


}
