package com.example.viewpagerpractice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.viewpagerpractice.R
import com.example.viewpagerpractice.viewpager.adapter.FragmentTabAdapter
import com.example.viewpagerpractice.viewpager.adapter.VpAdapter
import com.google.android.material.tabs.TabLayout
import javax.xml.transform.ErrorListener

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TabLayoutFragment : Fragment() {
  private var param1: String? = null
  private var param2: String? = null

  private lateinit var mViewPager: ViewPager
  private lateinit var mTabLayout: TabLayout

  private var mList: MutableList<Fragment> = mutableListOf()
  private var mTitle: MutableList<String> = mutableListOf()
  private lateinit var mAdapter: FragmentTabAdapter

  private var onCreatedListener: (() -> Unit)? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      param1 = it.getString(ARG_PARAM1)
      param2 = it.getString(ARG_PARAM2)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_tab_layout, container, false)
  }

  companion object {
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
      TabLayoutFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
          putString(ARG_PARAM2, param2)
        }
      }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mViewPager = view.findViewById(R.id.fragment_tab_vp)
    mTabLayout = view.findViewById(R.id.fragment_tab_layout)

    mAdapter = FragmentTabAdapter(childFragmentManager,mList,mTitle)
    mViewPager.adapter = mAdapter
    mTabLayout.setupWithViewPager(mViewPager)
    onCreatedListener?.invoke()
  }


  fun addItem(title: String = "默认标题", content: String = "默认内容"){
    mList.add(BasicFragment.newInstance(content,""))
    mTitle.add(title)
    mAdapter.updateData(mList,mTitle)
  }

  fun updateData(
    list: MutableList<Fragment>,
    title: MutableList<String>
  ){
    mList = list
    mTitle = title
    mAdapter.updateData(mList,mTitle)
  }

  fun setOnCreatedListener(listener: (() -> Unit)){
    onCreatedListener = listener
  }
}