package com.example.php

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        var arraylist = ArrayList<Php_class>()

    }
    lateinit var grid_view:GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var query = Volley.newRequestQueue(this)
        var url = "https://dummyjson.com/products"

        var string = StringRequest(Request.Method.GET, url, {

            var map = JSONObject(it)
            var array = map.getJSONArray("products")
            for (i in 0 until array.length()) {


                var objectt = array.getJSONObject(i)


                var title = objectt.getString("title")
                var price = objectt.getInt("price")
                var stock = objectt.getInt("stock")
                var rating = objectt.getInt("rating")
                var brand=objectt.getString("brand")
                var thumbnail=objectt.getString("thumbnail")

                var imagees=objectt.getJSONArray("images")

                var imagearray=ArrayList<String>()

                for (i in 0 until imagees.length()){

                        imagearray.add(imagees.getString(i))

                }

                var php = Php_class(title,price,stock,rating,brand,thumbnail,imagearray)
                arraylist.add(php)

                Log.e("===", "$php")

            }
            grid_view=findViewById(R.id.grid_view)


            var adapter=Class1(this, arraylist)

            grid_view.adapter=adapter

            grid_view.setOnItemClickListener { parent, view, position, id ->
                startActivity(Intent(this@MainActivity,pager::class.java).putExtra("array",
                    arraylist[position].imagearray))
            }

        }, {

            Log.e("===", "$it")
        })



        query.add(string)
    }
}