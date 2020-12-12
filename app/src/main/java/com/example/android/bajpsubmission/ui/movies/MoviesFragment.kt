package com.example.android.bajpsubmission.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android.bajpsubmission.databinding.FragmentMoviesBinding
import com.example.android.bajpsubmission.utils.ViewModelFactory
import com.example.android.bajpsubmission.utils.adapters.MoviesAdapter
import com.example.android.bajpsubmission.utils.hide
import com.example.android.bajpsubmission.utils.show

class MoviesFragment : Fragment() {

    lateinit var binding: FragmentMoviesBinding
    private val viewModel by viewModels<MoviesViewModel> {
        ViewModelFactory.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        loadMovies()
        onClickListener()
    }

    private fun loadMovies() {
        binding.pbMovies.show()
        binding.tvLoading.show()
        viewModel.getListMovies().observe(
            viewLifecycleOwner,
            {
                binding.pbMovies.hide()
                binding.tvLoading.hide()
            }
        )
    }

    private fun onClickListener() {
        binding.rvMovies.adapter = MoviesAdapter(
            MoviesAdapter.OnClickListener {
                this.findNavController()
                    .navigate(
                        MoviesFragmentDirections.actionNavigationMoviesToDetailFragment(it)
                    )
            }
        )
    }
}
