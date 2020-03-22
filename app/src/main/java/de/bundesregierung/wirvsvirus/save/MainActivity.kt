package de.bundesregierung.wirvsvirus.save

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wormDotsIndicator = wormsDotIndicator
        val viewPager = viewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        wormDotsIndicator.setViewPager(viewPager)

        toTheAppButton.setOnClickListener {
            val intent = Intent(this, ActivateActivity::class.java)
            startActivity(intent)
        }
    }


    class ViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment =
            when(position) {
                0 -> OnboardingOne.newInstance("", "")
                1 -> OnboardingTwo.newInstance("", "")
                2 -> OnboardingThree.newInstance("", "")
                else -> OnboardingOne.newInstance("", "")
            }


        override fun getCount(): Int {
            return 3
        }

    }


}



