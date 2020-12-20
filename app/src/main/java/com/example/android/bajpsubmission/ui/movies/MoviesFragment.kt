package com.example.android.bajpsubmission.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android.bajpsubmission.data.Resource.Status
import com.example.android.bajpsubmission.databinding.FragmentMoviesBinding
import com.example.android.bajpsubmission.utils.ViewModelFactory
import com.example.android.bajpsubmission.utils.adapters.MoviesAdapter
import com.example.android.bajpsubmission.utils.hide
import com.example.android.bajpsubmission.utils.show
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    lateinit var binding: FragmentMoviesBinding

    private val viewModel by viewModels<MoviesViewModel> {
        factory
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
        viewModel.getListMovies().observe(
            viewLifecycleOwner,
            { listMovie ->
                if (listMovie != null) {
                    when (listMovie.status) {
                        Status.LOADING -> {
                            binding.pbMovies.show()
                            binding.tvLoadingMovies.show()
                        }

                        Status.ERROR -> {
                            binding.pbMovies.hide()
                            binding.tvLoadingMovies.hide()
                            Toast.makeText(requireActivity(), listMovie.message, Toast.LENGTH_SHORT)
                                .show()
                        }

                        Status.DONE -> {
                            binding.pbMovies.hide()
                            binding.tvLoadingMovies.hide()
                            binding.rvMovies.show()
                        }
                    }
                }
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
