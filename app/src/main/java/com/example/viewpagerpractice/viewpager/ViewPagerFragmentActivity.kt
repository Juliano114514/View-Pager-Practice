package com.example.viewpagerpractice.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.fragment.BasicFragment
import com.example.viewpagerpractice.viewpager.adapter.FragmentVpAdapter

class ViewPagerFragmentActivity : AppCompatActivity() {

  private val mViewpager: ViewPager by lazy { findViewById<ViewPager>(R.id.vp_fragment) }
  private lateinit var mAdapter : FragmentVpAdapter
  private lateinit var mList : List<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.view_pager_fragment)

    initData()
    initView()
  }

  private fun initData(){
    val fgm1 = BasicFragment.newInstance("马嘉祺","")
    val fgm2 = BasicFragment.newInstance("丁晨曦","")
    val fgm3 = BasicFragment.newInstance("贺峻霖","")
    mList = listOf(fgm1, fgm2, fgm3)
  }

  private fun initView(){
    mAdapter = FragmentVpAdapter(supportFragmentManager, mList)
    mViewpager.adapter = mAdapter
  }
}