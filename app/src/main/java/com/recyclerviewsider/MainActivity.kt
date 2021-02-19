package com.recyclerviewsider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewsider.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

private lateinit var binding: ActivityMainBinding
private lateinit var images: ArrayList<String>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeData()
        initializeView()
    }

    private fun initializeView() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val imagesAdapter = ImagesAdapter(images)
        binding.rvImages.layoutManager = linearLayoutManager
        binding.rvImages.adapter = imagesAdapter
        slideItems()

    }

    private fun initializeData() {
        images = ArrayList()
        images.add("https://tse1.mm.bing.net/th?id=OIP.QqlIHgO3iTgj56OEfAu7-QHaHB&pid=Api&rs=1&c=1&qlt=95&w=131&h=124")
        images.add("https://tse4.mm.bing.net/th?id=OIP.ZZ432EqqLnntGQGopICBRAHaHY&pid=Api&P=0&w=300&h=300")
        images.add("https://tse1.mm.bing.net/th?id=OIP.tfObMl4UlRe5Ny0KEiEsdQHaHa&pid=Api&P=0&w=300&h=300")
        images.add("https://tse2.mm.bing.net/th?id=OIP.tTsKrnPmu6VGr0NYYdxMMwHaHH&pid=Api&P=0&w=164&h=158")
        images.add("https://tse3.mm.bing.net/th?id=OIP.9Ea8b7SZjiudZZ4C5jDppwHaKd&pid=Api&P=0&w=300&h=300")
    }

    private fun slideItems() {

        val timer = Timer()
        timer.scheduleAtFixedRate(ScrollTask(), 1000, 2000)
    }

    private class ScrollTask : TimerTask() {
        var nextView = 0
        var i = 0
        override fun run() {
            binding.rvImages.post(Runnable {
                if (images.size > nextView)
                    if (nextView == 0)
                        binding.rvImages.scrollToPosition(0)
                    else
                        binding.rvImages.smoothScrollToPosition(nextView)
                i++
                nextView = i % images.size
            })
        }
    }

}