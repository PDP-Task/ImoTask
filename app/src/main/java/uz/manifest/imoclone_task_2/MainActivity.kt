package uz.manifest.imoclone_task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import uz.manifest.imoclone_task_2.adapter.ViewPagerAdapter
import uz.manifest.imoclone_task_2.fragment.ContactFragment
import uz.manifest.imoclone_task_2.fragment.UserFragment

class MainActivity : AppCompatActivity() {
    private val tabIcons = intArrayOf(
        R.drawable.ic_person,
        R.drawable.ic_call
    )
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)
        viewPagerAdapter = ViewPagerAdapter(initFragments(), supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        setupTabsIcons()

    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            UserFragment(),
            ContactFragment()
        )
    }

    private fun setupTabsIcons() {
        tabLayout.getTabAt(0)?.setIcon(tabIcons[0])
        tabLayout.getTabAt(1)?.setIcon(tabIcons[1])
    }
}