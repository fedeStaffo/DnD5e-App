package com.progetto_dd.view.characters.visualizza.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.progetto_dd.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3,
    R.string.tab_text_4,
    R.string.tab_text_5
)


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PlaceholderFragment.newInstance(1)
            1 -> PlaceholderFragment.newInstance(2)
            2 -> PlaceholderFragment.newInstance(3)
            3 -> PlaceholderFragment.newInstance(4)
            4 -> PlaceholderFragment.newInstance(5)
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 5 total pages
        return 5
    }

}