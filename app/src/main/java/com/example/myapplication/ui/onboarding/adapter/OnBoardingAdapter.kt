package com.example.myapplication.ui.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemOnboardingBinding
import com.example.myapplication.ui.model.OnBoarding

class OnBoardingAdapter (private val onClick: ()->Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding("Представь", "Ты мололодой Банан", "https://sun9-15.userapi.com/impg/r_TdgKIo2JBhHmOi4Tb6HRG1B0l4PhY2fCR12Q/Va5VhZddGuM.jpg?size=1080x783&quality=95&sign=1796f4ec92c234ea9825bb56f389689a&c_uniq_tag=UOB8z9oixz84Odp1N-8y9fD31XgflqT2gMZZxEWC8RA&type=album"),
        OnBoarding("И ты покупаешь себе", "Пацан черного цвета", "https://i.ebayimg.com/thumbs/images/g/WOcAAOSwofxUcMmJ/s-l1600.jpg"),
        OnBoarding("Все у тебя спрашивают, что у тебя за пацан?", "Ты говоришь,черный пацан", "https://i.ytimg.com/vi/ZNRkV7Ml5vE/maxres2.jpg?sqp=-oaymwEoCIAKENAF8quKqQMcGADwAQH4AZQDgALQBYoCDAgAEAEYZSBHKEAwDw==&amp;rs=AOn4CLAHBfYe_HAX0EUgsL00V3tSY75jaw"),
    )




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {


        fun bind(onBoarding: OnBoarding) {
            binding.title.text = onBoarding.title
            binding.desc.text = onBoarding.desc

            Glide.with(binding.ivBoard)
                .load(onBoarding.image)
                .into(binding.ivBoard)

            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.skip.isVisible = adapterPosition != data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.skip.setOnClickListener{
                onClick()
            }
        }

    }
}