package com.example.newsly.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsly.R
import com.example.newsly.databinding.ActivityMainBinding
import com.example.newsly.ui.db.ArticleDatabase
import com.example.newsly.ui.repository.NewsRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        // Access the bottom nav using ViewBinding
        val navController = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment)
        binding.bottomNavigationView.setupWithNavController(navController!!.findNavController())
    }
}
