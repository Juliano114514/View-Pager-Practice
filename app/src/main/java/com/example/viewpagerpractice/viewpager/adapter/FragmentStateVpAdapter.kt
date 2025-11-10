package com.example.viewpagerpractice.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentStateVpAdapter(
  fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

  constructor(
    fm: FragmentManager,
    list: List<Fragment> = emptyList<Fragment>()
  ) : this(fm) {
    mList = list
  }

  private var mList: List<Fragment> = emptyList<Fragment>()

  override fun getItem(position: Int): Fragment {
    return mList[position]
  }

  override fun getCount(): Int {
    return mList.size
  }
}