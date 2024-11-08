package com.rrbofficial.rohitbalage.ui.home

import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rrbofficial.rohitbalage.R
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.holder.BannerImageHolder

class BannerImageAdapter(private val imageList: List<String>) : BannerAdapter<String, BannerImageHolder>(imageList) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerImageHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerImageHolder(imageView)
    }

    override fun onBindView(holder: BannerImageHolder, data: String, position: Int, size: Int) {
        Glide.with(holder.itemView)
            .load(data)
            .into(holder.imageView)
    }
}