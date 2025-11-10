package com.example.viewpagerpractice.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentTabAdapter(
  fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

  constructor(
    fm: FragmentManager,
    list: List<Fragment> = emptyList<Fragment>(),
    title: List<String> = emptyList<String>()
  ) : this(fm) {
    mList = list
    mTitle = title
  }

  fun updateData(
    list: List<Fragment> = emptyList<Fragment>(),
    title: List<String> = emptyList<String>()
  ){
    mList = list
    mTitle = title
    notifyDataSetChanged()
  }

  private var mList: List<Fragment> = emptyList<Fragment>()
  private var mTitle: List<String> = emptyList<String>()

  override fun getItem(position: Int): Fragment {
    return mList[position]
  }

  override fun getCount(): Int {
    return mList.size
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return mTitle[position]
  }
}