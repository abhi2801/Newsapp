package com.mycompany.learningkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import com.mycompany.learningkotlin.R
import com.mycompany.learningkotlin.viewmodel.ArticleViewModel

class BusinessFragment : Fragment() {
     lateinit var viewModel: ArticleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=(activity as MainActivity).viewModel
        return inflater.inflate(R.layout.fragment_science, container, false)
    }
}