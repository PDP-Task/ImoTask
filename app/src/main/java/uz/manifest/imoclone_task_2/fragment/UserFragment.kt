package uz.manifest.imoclone_task_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.imoclone_task_2.R
import uz.manifest.imoclone_task_2.adapter.UserAdapter
import uz.manifest.imoclone_task_2.model.User

class UserFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_user)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        userAdapter = UserAdapter(userList())
        recyclerView.adapter = userAdapter
    }

    private fun userList(): ArrayList<User> {
        for (i in 0..20) {
            when {
                i % 3 == 0 -> {
                    userList.add(User(R.drawable.img_android, "Android", 1, true))
                }
                i % 5 == 0 -> {
                    userList.add(User(R.drawable.kotlin_img, "Kotlin", 3, false))
                }
                else -> {
                    userList.add(User(R.drawable.java, "Java", 2, true))
                }
            }
        }
        return userList
    }
}