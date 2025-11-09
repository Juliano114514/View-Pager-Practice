package com.example.viewpagerpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpagerpractice.viewpager.ViewpagerActivity

class MainActivity: AppCompatActivity() {

  private lateinit var toViewButton: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_layout)
    initView()
    initListener()
  }

  fun initView(){
    toViewButton = findViewById(R.id.load_view)
  }

  fun initListener(){
    toViewButton.setOnClickListener {
      val intent = Intent(this, ViewpagerActivity::class.java)
      startActivity(intent)
    }
  }
}