package com.mycompany.learningkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mycompany.learningkotlin.R
import com.mycompany.learningkotlin.model.Article
import kotlinx.android.synthetic.main.row_item.view.*

class NewsAdapter(val onclick: OnItemClickListener):RecyclerView.Adapter<NewsAdapter.NewsVH>() {
    inner class NewsVH(view: View):RecyclerView.ViewHolder(view)
    private val differCallback=object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url
        }
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem==newItem
        }
    }
    private val differ=AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        return NewsVH(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item,parent,false))
    }
    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val article=differ.currentList.get(position)
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(newsImage)
            newsTitle.text=article.title
            newsTime.text=article.publishedAt
            setOnClickListener {
                onclick.onClick(article)
            }
        }
    }
    override fun getItemCount(): Int {
       return differ.currentList.size
    }
}
interface OnItemClickListener{
    fun onClick(article: Article)
}