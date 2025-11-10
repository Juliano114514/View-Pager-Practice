package com.example.viewpagerpractice.viewpager

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.fragment.BasicFragment
import com.example.viewpagerpractice.viewpager.adapter.FragmentVpAdapter

class ViewpagerFragmentNaviActivity : AppCompatActivity() {

  private val viewpager: ViewPager by lazy{ findViewById(R.id.vp_navi) }
  private lateinit var mAdapter : FragmentVpAdapter

  private val textViews = mutableListOf<TextView>()
  private val emojiViews = mutableListOf<TextView>()
  private val buttonLayouts = mutableListOf<LinearLayout>()

  private var originText = mutableListOf<String>()
  private var originEmoji = mutableListOf<String>()
  private lateinit var selectedText : List<String>
  private lateinit var selectedEmoji : List<String>

  private lateinit var mList: List<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_navi)

    initView()
    initData()
    initListener()
  }

  private fun initView(){
    textViews.add(findViewById(R.id.txt1))
    textViews.add(findViewById(R.id.txt2))
    textViews.add(findViewById(R.id.txt3))

    emojiViews.add(findViewById(R.id.emj1))
    emojiViews.add(findViewById(R.id.emj2))
    emojiViews.add(findViewById(R.id.emj3))

    buttonLayouts.add(findViewById(R.id.emm))
    buttonLayouts.add(findViewById(R.id.maa))
    buttonLayouts.add(findViewById(R.id.aaa))
  }

  private fun initData(){
    textViews.forEach{ view ->
      originText.add(view.text.toString())
    }

    emojiViews.forEach { view ->
      originEmoji.add(view.text.toString())
    }

    selectedText = listOf("嗯～", "嘛？","啊！")
    selectedEmoji = listOf("😋","😨","😭")

    val fgm1 = BasicFragment.newInstance("马嘉祺","")
    val fgm2 = BasicFragment.newInstance("丁晨曦","")
    val fgm3 = BasicFragment.newInstance("贺峻霖","")
    mList = listOf(fgm1, fgm2, fgm3)
  }

  private fun initListener(){
    mAdapter = FragmentVpAdapter(supportFragmentManager, mList)
    viewpager.adapter = mAdapter

    viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
      override fun onPageScrolled(pos: Int, posOffset: Float, posOffsetPx: Int
      ) {

      }

      override fun onPageSelected(pos: Int) {
        textViews.forEachIndexed { idx, view ->
          if(idx == pos) view.text = selectedText[idx]
          else view.text = originText[idx]
        }

        emojiViews.forEachIndexed { idx, view ->
          if(idx == pos) view.text = selectedEmoji[idx]
          else view.text = originEmoji[idx]
        }
      }

      override fun onPageScrollStateChanged(state: Int) {

      }

    })

    buttonLayouts.forEachIndexed { idx,view ->
      view.setOnClickListener {
        viewpager.setCurrentItem(idx)
      }
    }
  }
}