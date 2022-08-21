package com.mycompany.learningkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mycompany.learningkotlin.R
import com.mycompany.learningkotlin.repository.ArticleRepository
import com.mycompany.learningkotlin.utils.ArticleViewModelFactory
import com.mycompany.learningkotlin.viewmodel.ArticleViewModel
import com.mycompany.room.ArticleDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var viewModel: ArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(ArticleViewModel::class.java)
        val host=supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment
        navController=host.findNavController()
        bottomNavigationView=findViewById(R.id.bottomNav)
        setupWithNavController(bottomNavigationView,navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_news,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)|| super.onOptionsItemSelected(item)
    }
}