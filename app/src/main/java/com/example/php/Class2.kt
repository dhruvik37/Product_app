package com.example.php

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import java.util.ArrayList

class Class2(var pager: pager, var array: ArrayList<String>?) :PagerAdapter() {
    override fun getCount(): Int {
        return array!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var view2=LayoutInflater.from(pager).inflate(R.layout.imagesviecwer,container,false)

        var pagerview:ImageView
        pagerview=view2.findViewById(R.id.pagerview)
        Glide.with(this.pager).load(array!![position]).into(pagerview)
        container.addView(view2)

        return view2
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }



}
