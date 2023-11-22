package thee.jmc.theevolutionofmodernsports

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class CustomItemAnimator : DefaultItemAnimator() {

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        val scaleAnimation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.center_reveal_anim)
        holder.itemView.startAnimation(scaleAnimation)
        return super.animateAdd(holder)
    }

    // Implement other required animation methods
}
