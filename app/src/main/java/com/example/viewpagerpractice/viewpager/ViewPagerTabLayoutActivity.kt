package com.example.viewpagerpractice.viewpager

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.fragment.BadgeFragment
import com.example.viewpagerpractice.fragment.BasicFragment
import com.example.viewpagerpractice.fragment.TabLayoutFragment
import com.example.viewpagerpractice.interfaces.BadgeInterface
import com.example.viewpagerpractice.viewpager.adapter.FragmentStateVpAdapter
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewPagerTabLayoutActivity : AppCompatActivity() , BadgeInterface{

  private val mViewPager: ViewPager by lazy { findViewById(R.id.tab_vp) }
  private val mBtnNavi: BottomNavigationView by lazy { findViewById(R.id.tab_bottom_menu) }
  private val mAddBtn: Button by lazy { findViewById(R.id.tab_add_btn) }

  private lateinit var mAdapter: FragmentStateVpAdapter
  private lateinit var mList : List<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.view_pager_tab_layout)

    initData()
    initListener()
  }

  private fun initData(){
    val fgm1 = TabLayoutFragment.newInstance("","")
    fgm1.setOnCreatedListener { initSubData() }

    val fgm2 = TabLayoutFragment.newInstance("","")
    val fgm3 = BadgeFragment.newInstance("","")
    mList = listOf(fgm1, fgm2, fgm3)

    mAdapter = FragmentStateVpAdapter(supportFragmentManager, mList)
    mViewPager.adapter = mAdapter
  }

  private fun initListener(){
    mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
      override fun onPageScrolled(pos: Int, posOffset: Float, posOffsetPx: Int) { }
      override fun onPageSelected(pos: Int) {
        updateSelected(pos)
      }
      override fun onPageScrollStateChanged(state: Int) { }
    })

    mBtnNavi.setOnItemSelectedListener { item ->
      val position = when (item.itemId) {
        R.id.menu_home -> 0
        R.id.menu_list -> 1
        R.id.menu_setting -> 2
        else -> return@setOnItemSelectedListener false
      }
      mViewPager.setCurrentItem(position)
      true
    }

    mAddBtn.setOnClickListener {
      val pos = mViewPager.currentItem
      val fgm = mList[pos]
      if(fgm is TabLayoutFragment){
        fgm.addItem()
      } else {
        Toast.makeText(this@ViewPagerTabLayoutActivity,"当前页面不支持TabLayout!",Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun updateSelected(pos: Int){
    when(pos){
      0 -> {
        mBtnNavi.selectedItemId = R.id.menu_home
        removeBadge(R.id.menu_home)
      }
      1 -> {
        mBtnNavi.selectedItemId = R.id.menu_list
        removeBadge(R.id.menu_list)
      }
      2 -> {
        mBtnNavi.selectedItemId = R.id.menu_setting
        removeBadge(R.id.menu_setting)
      }
      else -> return
    }
  }


  override fun addBadge(ResId: Int, addCount: Int){
    var badge: BadgeDrawable = mBtnNavi.getOrCreateBadge(ResId)
    if(addCount > 0)badge.number = badge.number + addCount
  }

  override fun removeBadge(ResId: Int){
    mBtnNavi.removeBadge(ResId)
  }

  fun initSubData(){
    var mSubList: MutableList<Fragment> = mutableListOf()
    var mSubTitle: MutableList<String> = mutableListOf()

    mSubList.add(BasicFragment.newInstance("不管喜和悲",""))
    mSubList.add(BasicFragment.newInstance("卡拉永远ok",""))
    mSubList.add(BasicFragment.newInstance("幻梦都破碎",""))
    mSubList.add(BasicFragment.newInstance("卡拉也会ok",""))
    mSubTitle.add("高声")
    mSubTitle.add("唱尽")
    mSubTitle.add("心中")
    mSubTitle.add("滋味")

    val fgm = mList[0] as TabLayoutFragment
    fgm.updateData(mSubList,mSubTitle)
  }
}