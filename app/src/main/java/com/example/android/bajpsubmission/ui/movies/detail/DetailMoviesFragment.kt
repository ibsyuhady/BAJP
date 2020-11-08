package com.example.android.bajpsubmission.ui.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.android.bajpsubmission.databinding.FragmentDetailMoviesBinding

class DetailMoviesFragment : Fragment() {

    private lateinit var binding: FragmentDetailMoviesBinding
    private val detailMoviesViewModel by viewModels<DetailMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movies = DetailMoviesFragmentArgs.fromBundle(requireArguments()).detailMovies
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailMoviesViewModel
        detailMoviesViewModel.getDetailMovie(movies)
        binding.toolbarDetailMovies.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}
