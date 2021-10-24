package com.satyam.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artical)
        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val description = intent.getStringExtra("description")
        val url=intent.getStringExtra("url")

        val articleImage: ImageView = findViewById(R.id.image)
        val articleTitle: TextView = findViewById(R.id.title)
        val articleAuthor: TextView = findViewById(R.id.author)
        val articleDescription: TextView = findViewById(R.id.desc)
        val readMoreButton:Button=findViewById(R.id.read_more_button)

        Glide.with(this).load(image).into(articleImage)
        articleTitle.text = title
        articleAuthor.text = author
        articleDescription.text = description

        readMoreButton.setOnClickListener{
            val urlIntent=Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(urlIntent)

        }
    }

}