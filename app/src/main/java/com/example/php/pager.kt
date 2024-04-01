package com.example.php

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class pager : AppCompatActivity() {

    lateinit var images: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pager)


        var array=intent.getStringArrayListExtra("array")


        images=findViewById(R.id.images)

        var Myclass = Class2(this,array)
        images.adapter=Myclass


    }
}