package com.example.myapplication.ui.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.Image

class Pref(private val context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isOnBoardingShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun saveName(name: String){
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String?{
        return pref.getString(NAME_KEY, null)
    }

    fun saveImage(image: String){
        pref.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String{
        return pref.getString(NAME_KEY, "").toString()
    }

    fun saveAge(age: String){
        pref.edit().putString(AGE_KEY, age).apply()
    }

    fun getAge(): String{
        return pref.getString(AGE_KEY,"").toString()
    }

    fun saveFloor(floor: String){
        pref.edit().putString(FLOOR_KEY, floor).apply()
    }

    fun getFloor(): String{
        return pref.getString(FLOOR_KEY, "").toString()
    }








    companion object {
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "showed.key"
        const val NAME_KEY = "name.key"
        const val AGE_KEY = "age.key"
        const val FLOOR_KEY = "floor.key"
        const val IMAGE_KEY = "image.key"
    }

}