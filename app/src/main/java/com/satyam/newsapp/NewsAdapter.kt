package com.satyam.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val list: List<Articles>,private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleText:TextView=itemView.findViewById(R.id.title_text)
        val descText:TextView=itemView.findViewById(R.id.descText)
        val imageView:ImageView=itemView.findViewById(R.id.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val itemView =LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleText.text=list[position].title
        holder.descText.text=list[position].title
        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent= Intent(context,ArticleActivity::class.java)
            intent.putExtra("image",list[position].urlToImage)
            intent.putExtra("title",list[position].title)
            intent.putExtra("author",list[position].author)
            intent.putExtra("description",list[position].description)
            intent.putExtra("url",list[position].url)
           //can do above lines val bundle= bundleOf("image" to list[position].urlToImage,"title" to list[position].title,-----)
           //intent.extras?.putAll(bundle)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
    return list.size
    }

}