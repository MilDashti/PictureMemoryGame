package com.example.picturememorygame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.picturememorygame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var hey: MutableMap<View, Int> = mutableMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewss: List<View> = listOf(
            pic1,
            pic10,
            pic11,
            pic9,
            pic8,
            pic7,
            pic6,
            pic5,
            pic4,
            pic3,
            pic2,
            pic12,
            pic13,
            pic14,
            pic15,
            pic16
        )

        for (item in viewss) item.setOnClickListener { item.setBackggroundColor(hey.get(item)!!) }


        binding.button.setOnClickListener {
            randomize(viewss)

            Timer(
                "setting up",
                false
            ).schedule(2000) {
                for (item in viewss) item.setBackgroundResource(R.color.myColor)
//                Toast.makeText(applicationContext,
//                    "Now that you have seen the colors start guessing the colored pairs by clicking on the boxes above",
//                    Toast.LENGTH_LONG
//                ).show()
            }
        }
    }


    fun randomize(list: List<View>) {
        var colors: MutableList<Int> = mutableListOf(
            R.color.black,
            R.color.blue,
            R.color.colorAccent,
            R.color.yellow,
            R.color.red,
            R.color.myColor,
            R.color.colorPrimaryDark,
            R.color.colorPrimary
        )

        colors.addAll(colors)



        Collections.shuffle(list)
        var i = 0
        for (items in list) {
            items.setBackgroundResource(colors[i++])
            hey.plus(items to colors)
        }


    }

//    fun work(view: View) {
//
//
//    }

}
