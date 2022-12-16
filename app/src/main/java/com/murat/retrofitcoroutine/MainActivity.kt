package com.murat.retrofitcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murat.retrofitcoroutine.adapter.TvShowAdapter
import com.murat.retrofitcoroutine.databinding.ActivityMainBinding

import com.murat.retrofitcoroutine.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : TvShowViewModel by viewModels( )
    private lateinit var tvShowAdapter : TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAppRv()

    }

    private fun setAppRv() {
        tvShowAdapter = TvShowAdapter()

        setupRecyclers(binding.recyclerView)
        setupRecyclers(binding.rvEpisode)
        setupRecyclers(binding.rvRecentlyAdded)

        viewModel._response.observe(this) {
            tvShowAdapter.tvShow = it

        }

    }
    private fun setupRecyclers(rv : RecyclerView) {
        rv.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }

    }
}