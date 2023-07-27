package com.example.recyclerview.adapters

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Channel
import com.example.recyclerview.HomeFeed
import com.example.recyclerview.R
import com.squareup.picasso.Picasso


class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {


    val videoTitles = listOf("First title", "Second", "3rd", "MOOOOORE TITLE")

    // numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // how do we even create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed.videos[position]
        val channel = video.channel

        holder.view.findViewById<TextView>(R.id.textView_video_title).text = video.name
        holder.view.findViewById<TextView>(R.id.textView_channel_name).text = video.channel.name + "   •   " + "20k views \n 4 days ago"

        val thumbnailImageView = holder.view.findViewById<ImageView>(R.id.imageView_video_thumbnail)
        Picasso.get().load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder.view.findViewById<ImageView>(R.id.imageView_channel_profile)
        Picasso.get().load(channel.profileImageUrl).into(channelProfileImageView)
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}


