package com.example.viewpagerpractice.viewpager.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class VpAdapter : PagerAdapter {

  private var mImageList: List<ImageView>? = null

  constructor(list: List<ImageView>){
    mImageList = list
  }

  override fun getCount(): Int {
    return mImageList?.size ?: 0
  }

  override fun isViewFromObject(view: View, mObject: Any): Boolean {
    return view == mObject
  }


  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val img = mImageList?.get(position)
    container.addView(img)
    return img!!
  }

  override fun destroyItem(container: ViewGroup, position: Int, mObject: Any) {
    container.removeView(mObject as View)
  }
}