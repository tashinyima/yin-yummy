package com.example.yinyummy.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.yinyummy.extensions.loadCircleImage
import com.example.yinyummy.extensions.loadImage
import de.hdodenhof.circleimageview.CircleImageView

class PopularItemBinder {
    companion object {

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imgView: ImageView, url: String) {
            imgView.loadImage(url)
        }

        @BindingAdapter("loadCircleImage")
        @JvmStatic
        fun loadCircleImage(img: CircleImageView, url: String){
            img.loadCircleImage(url)
        }

        @BindingAdapter("convertIntToText")
        @JvmStatic
        fun covertIntToText(textView: TextView, int: Int){
            textView.text=int.toString()
        }
        @BindingAdapter("convertDoubleToText")
        @JvmStatic
        fun convertDoubleToText(textView: TextView,double: Double){
            textView.text = double.toString()
        }





    }
}