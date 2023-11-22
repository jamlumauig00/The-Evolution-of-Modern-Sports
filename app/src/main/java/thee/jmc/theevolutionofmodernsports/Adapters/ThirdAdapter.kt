package thee.jmc.theevolutionofmodernsports.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.R

class ThirdAdapter(var mainlist: Array<String>, private val onItemClickListener: AdapterOnClick, val context: Context) :
    RecyclerView.Adapter<ThirdAdapter.ViewHolder>() {

    class ViewHolder(v: View, private var itemClick: AdapterOnClick, val context: Context) : RecyclerView.ViewHolder(v),
        View.OnClickListener {
        private val title: TextView = v.findViewById(R.id.second_title)
        private val desc: TextView = v.findViewById(R.id.second_description)

        fun bindIdea(dataPor: String) {
            desc.visibility = View.GONE
            title.text = dataPor
            title.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            itemClick.onclick(adapterPosition)
            Log.e("adapterPositionPOSITION", adapterPosition.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.secondlayout, parent, false
        ), onItemClickListener, context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindIdea(mainlist[position])
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }


}
