package com.example.android.bajpsubmission.ui.movies.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.bajpsubmission.databinding.FragmentDetailMoviesBinding

class DetailMoviesFragment : Fragment() {

    private lateinit var binding: FragmentDetailMoviesBinding

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

        val application = requireNotNull(activity).application
        val movies = DetailMoviesFragmentArgs.fromBundle(requireArguments()).detailMovies
        val viewModelFactory = DetailMoviesViewModelFactory(movies, application)
        val detailMoviesViewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(DetailMoviesViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailMoviesViewModel
        binding.toolbarDetailMovies.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}
