package com.example.yinyummy.extensions

import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.yinyummy.R
import de.hdodenhof.circleimageview.CircleImageView

fun ImageView.loadImage(url: String?){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_logo)
        .into(this)
}


fun CircleImageView.loadCircleImage(url: String?){
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.profile_img)
        .into(this)
}

fun Fragment.setActivityTitle(@StringRes id: Int) {
    (activity as AppCompatActivity?)?.supportActionBar?.title = getString(id)
}

fun Fragment.setActivityTitle(title: String) {
    (activity as AppCompatActivity?)?.supportActionBar?.title = title
}