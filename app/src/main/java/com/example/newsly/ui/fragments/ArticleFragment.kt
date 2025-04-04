package com.example.newsly.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsly.R
import com.example.newsly.databinding.FragmentArticleBinding
import com.example.newsly.ui.MainActivity
import com.example.newsly.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        _binding = FragmentArticleBinding.bind(view)

        val article = args.article
        article.url?.let { url ->
            binding.webView.apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        } ?: run {
            // Handle null URL case (optional)
        }

        binding.fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view , "Article saved successfully" , Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
