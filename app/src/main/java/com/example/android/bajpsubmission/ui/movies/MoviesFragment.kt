package com.example.android.bajpsubmission.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android.bajpsubmission.databinding.FragmentMoviesBinding
import com.example.android.bajpsubmission.utils.adapters.MoviesAdapter

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        onClickListener()
    }

    private fun onClickListener() {
        binding.rvMovies.adapter = MoviesAdapter(
            MoviesAdapter.OnClickListener {
                this.findNavController()
                    .navigate(MoviesFragmentDirections.actionNavigationMoviesToDetailFragment(it))
            }
        )
    }
}
