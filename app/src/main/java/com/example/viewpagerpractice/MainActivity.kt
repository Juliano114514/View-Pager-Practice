package com.example.viewpagerpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpagerpractice.viewpager.ViewPagerFragmentActivity
import com.example.viewpagerpractice.viewpager.ViewpagerActivity
import com.example.viewpagerpractice.viewpager.ViewpagerFragmentNaviActivity

class MainActivity: AppCompatActivity() {

  private lateinit var toViewButton: Button
  private lateinit var toFragmentButton: Button
  private lateinit var toFragmentNaviButton: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_layout)
    initView()
    initListener()
  }

  fun initView(){
    toViewButton = findViewById(R.id.load_view)
    toFragmentButton = findViewById(R.id.load_fragment)
    toFragmentNaviButton = findViewById(R.id.load_fragment_navi)
  }

  fun initListener(){
    toViewButton.setOnClickListener {
      val intent = Intent(this, ViewpagerActivity::class.java)
      startActivity(intent)
    }

    toFragmentButton.setOnClickListener {
      val intent = Intent(this, ViewPagerFragmentActivity::class.java)
      startActivity(intent)
    }

    toFragmentNaviButton.setOnClickListener {
      val intent = Intent(this, ViewpagerFragmentNaviActivity::class.java)
      startActivity(intent)
    }
  }
}