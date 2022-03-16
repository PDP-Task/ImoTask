package uz.manifest.imoclone_task_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.imoclone_task_2.R
import uz.manifest.imoclone_task_2.model.User
import uz.manifest.imoclone_task_2.util.Time

class UserAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]

        if (holder is UserViewHolder) {
            holder.apply {
                profileImg.setImageResource(user.profile)
                tvFullName.text = user.fullName
                tvCount.text = user.count.toString()

                if (user.isOnline) {
                    tvCount.setBackgroundResource(R.drawable.shape_circle_green)
                }
                if (user.count > 0)
                    tvCount.visibility = View.VISIBLE
                else
                    tvCount.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImg: ImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_full_name)
        val tvCount: TextView = view.findViewById(R.id.tv_count)
        private val tvTime: TextView = view.findViewById(R.id.tv_time)

        init {
            tvTime.text = Time.timeStamp()
        }
    }
}