package com.example.viewpagerpractice.viewpager


import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.viewpager.adapter.VpAdapter

class ViewpagerActivity : AppCompatActivity(){

  private lateinit var viewPager: ViewPager
  private lateinit var mAdapter: VpAdapter
  private lateinit var mList: List<ImageView>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.view_pager_basic)
    initData()
    initView()
  }

  fun initData(){
    val img1 = ImageView(this)
    val img2 = ImageView(this)
    val img3 = ImageView(this)
    img1.setImageResource(R.drawable.image)
    img2.setImageResource(R.drawable.image2)
    img3.setImageResource(R.drawable.image3)

    mList = listOf(img1,img2,img3)
    mAdapter = VpAdapter(mList)
  }

  fun initView(){
    viewPager = findViewById(R.id.vp_basic)
    viewPager.adapter = mAdapter
  }
}