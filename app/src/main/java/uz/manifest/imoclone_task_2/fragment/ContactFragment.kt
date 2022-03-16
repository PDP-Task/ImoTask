package uz.manifest.imoclone_task_2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.imoclone_task_2.R
import uz.manifest.imoclone_task_2.adapter.ContactAdapter
import uz.manifest.imoclone_task_2.model.Contact

class ContactFragment : Fragment() {
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private val contactList: ArrayList<Contact> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_contact)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        contactAdapter = ContactAdapter(contactList())
        recyclerView.adapter = contactAdapter
    }

    private fun contactList(): ArrayList<Contact> {
        for (i in 0..20) {
            when {
                i % 5 == 0 -> {
                    contactList.add(Contact("Android"))
                }
                i % 3 == 0 -> {
                    contactList.add(Contact("Java"))
                }
                else -> {
                    contactList.add(Contact("Kotlin"))
                }
            }
        }
        return contactList
    }
}