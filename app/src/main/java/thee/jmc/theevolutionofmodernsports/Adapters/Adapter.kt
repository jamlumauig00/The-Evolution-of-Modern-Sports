package thee.jmc.theevolutionofmodernsports.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import thee.jmc.theevolutionofmodernsports.R

class Adapter(var mainlist: Array<String>, private val onItemClickListener: AdapterOnClick, val context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(v: View, private var itemClick: AdapterOnClick, val context: Context) : RecyclerView.ViewHolder(v),
        View.OnClickListener {
        private val title: TextView = v.findViewById(R.id.title)
        private val btn1: CardView = v.findViewById(R.id.btn1)

        fun bindIdea(dataPor: String) {
            title.text = dataPor
            val center_reveal_anim = AnimationUtils.loadAnimation(context,
                R.anim.center_reveal_anim
            )
            //title.startAnimation(center_reveal_anim)
            btn1.startAnimation(center_reveal_anim)
            title.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            itemClick.onclick(adapterPosition)
            Log.e("adapterPositionPOSITION", adapterPosition.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.cardview, parent, false
        ), onItemClickListener, context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindIdea(mainlist[position])
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }


}
