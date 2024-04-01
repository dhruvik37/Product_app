    package com.example.php

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.core.net.toUri
    import com.bumptech.glide.Glide
    import java.util.ArrayList

    class Class1(var mainActivity: MainActivity, var arraylist: ArrayList<Php_class>) :BaseAdapter(){
        override fun getCount(): Int {
            return arraylist.size
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var thumbnail1:ImageView
            var title1:TextView
            var price1:TextView
            var stock1:TextView
            var brand1:TextView
            var rating1:TextView

            var view=LayoutInflater.from(mainActivity).inflate(R.layout.listaddapter,parent,false)

            thumbnail1=view.findViewById(R.id.thumbnail1)
            title1=view.findViewById(R.id.title1)
            price1=view.findViewById(R.id.price1)
            stock1=view.findViewById(R.id.stock1)
            brand1=view.findViewById(R.id.brand1)
            rating1=view.findViewById(R.id.rating1)



          //thumbnail1.setImageResource(arraylist[position].thumbnail.toInt())

            Glide.with(this@Class1.mainActivity).load(arraylist[position].thumbnail).into(thumbnail1)
            title1.setText(arraylist[position].title)
            price1.setText(arraylist[position].price.toString())
            stock1.setText("available :"+arraylist[position].stock.toString())
            brand1.setText("brand :"+arraylist[position].brand)
            rating1.setText("rating :"+arraylist[position].rating.toString())

            return view
        }

    }
