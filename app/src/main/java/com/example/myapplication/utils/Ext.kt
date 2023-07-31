package com.example.myapplication.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.R

fun Fragment.showToast(msg: String){
    Toast.makeText(requireContext(),msg, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImage(url : String){
    Glide.with(this).load(url).placeholder(R.drawable.ic_profile).into(this)
}
