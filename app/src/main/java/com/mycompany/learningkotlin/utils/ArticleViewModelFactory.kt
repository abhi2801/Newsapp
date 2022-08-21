package com.mycompany.learningkotlin.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mycompany.learningkotlin.repository.ArticleRepository
import com.mycompany.learningkotlin.viewmodel.ArticleViewModel

class ArticleViewModelFactory(private val repository:ArticleRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(repository) as T
    }
}