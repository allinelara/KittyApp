package com.allinedelara.kittyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(
    private var clickListener: () -> Unit,
) : ListAdapter<String, ImageAdapter.ViewHolder>(ImageDiff()) {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image)
        private val url: TextView = itemView.findViewById(R.id.url)

        fun initialize(image: String, view: View) {
            url.text = image
            Glide.with(view.context)
                .load(image) // image url
                .placeholder(R.drawable.loading) // any placeholder to load at start
                .error(R.drawable.error)  // any image in case of error
                .override(800) // resizing
                .centerCrop()
                .into(imageView)

            itemView.setOnClickListener {
                clickListener.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vehicleView = inflater.inflate(R.layout.image_item, parent, false)
        return ViewHolder(vehicleView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.initialize(getItem(position), viewHolder.itemView)
    }

    private class ImageDiff : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }
}