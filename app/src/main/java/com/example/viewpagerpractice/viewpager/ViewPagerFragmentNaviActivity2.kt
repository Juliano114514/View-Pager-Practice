package com.example.viewpagerpractice.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.fragment.BadgeFragment
import com.example.viewpagerpractice.fragment.BasicFragment
import com.example.viewpagerpractice.interfaces.BadgeInterface
import com.example.viewpagerpractice.viewpager.adapter.FragmentStateVpAdapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewPagerFragmentNaviActivity2 : AppCompatActivity(), BadgeInterface{

  private val viewPager: ViewPager by lazy { findViewById(R.id.vp_navi2) }
  private val btnNavi: BottomNavigationView by lazy { findViewById(R.id.bottom_menu)}
  private lateinit var mAdapter: FragmentStateVpAdapter
  private lateinit var mList: List<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.view_pager_navi2)

    initData()
    initView()
    initListener()
  }

  private fun initData(){
    val fgm1 = BasicFragment.newInstance("马嘉祺","")
    val fgm2 = BasicFragment.newInstance("丁晨曦","")
    val fgm3 = BadgeFragment.newInstance("","")
    mList = listOf(fgm1, fgm2, fgm3)
  }

  private fun initView(){
    mAdapter = FragmentStateVpAdapter(supportFragmentManager, mList)
    viewPager.adapter = mAdapter


  }

  private fun initListener(){
    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
      override fun onPageScrolled(pos: Int, posOffset: Float, posOffsetPx: Int) { }
      override fun onPageSelected(pos: Int) {
        updateSelected(pos)
      }
      override fun onPageScrollStateChanged(state: Int) { }
    })

    btnNavi.setOnItemSelectedListener { item ->
      val position = when (item.itemId) {
        R.id.menu_home -> 0
        R.id.menu_list -> 1
        R.id.menu_setting -> 2
        else -> return@setOnItemSelectedListener false
      }
      viewPager.setCurrentItem(position)
      true
    }
  }

  private fun updateSelected(pos: Int){
    when(pos){
      0 -> {
        btnNavi.selectedItemId = R.id.menu_home
        removeBadge(R.id.menu_home)
      }
      1 -> {
        btnNavi.selectedItemId = R.id.menu_list
        removeBadge(R.id.menu_list)
      }
      2 -> {
        btnNavi.selectedItemId = R.id.menu_setting
        removeBadge(R.id.menu_setting)
      }
      else -> return
    }
  }

  override fun addBadge(ResId: Int, addCount: Int){
    var badge: BadgeDrawable = btnNavi.getOrCreateBadge(ResId)
    if(addCount > 0)badge.number = badge.number + addCount
  }

  override fun removeBadge(ResId: Int){
    btnNavi.removeBadge(ResId)
  }
}