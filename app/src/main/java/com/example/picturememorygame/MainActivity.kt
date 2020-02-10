package com.example.picturememorygame

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.picturememorygame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
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


        var objs: Stack<Pair<View, Int>> = Stack()
        for (item in viewss) item.setOnClickListener {
            var gg: Pair<View, Int> = item to hey.getValue(item)
            objs.push(gg)
            item.setBackgroundResource(hey.getValue(item))
            Timer("setting", false).schedule(500) { }
            if (objs.size == 2) {
                var obj1 = objs.pop()
                var obj2 = objs.pop()

                if (obj1.second == obj2.second) {
                    Toast.makeText(this, "Good Job", Toast.LENGTH_SHORT).show()
                    obj1.first.isEnabled = false
                    obj1.first.background.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
                    obj2.first.isEnabled = false
                    obj2.first.background.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY)
                } else {
                    Timer("setting", false).schedule(500) {

                        obj1.first.setBackgroundResource(R.color.myColor)
                        obj2.first.setBackgroundResource(R.color.myColor)
                    }

                }


            }
        }

        

        binding.button.setOnClickListener {
            randomize(viewss)
            for(items in viewss){
                items.isEnabled=true
            }
            Timer(
                "setting up",
                false
            ).schedule(2000) {
                for (item in viewss) item.setBackgroundResource(R.color.myColor)
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
            R.color.random,
            R.color.colorPrimaryDark,
            R.color.colorPrimary
        )

        colors.addAll(colors)



        Collections.shuffle(list)
        var i = 0
        for (items in list) {
            hey.put(items, colors[i])
            items.setBackgroundResource(colors[i++])

        }
    }
}