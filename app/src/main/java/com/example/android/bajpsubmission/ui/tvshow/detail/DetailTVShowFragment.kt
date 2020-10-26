package com.example.android.bajpsubmission.ui.tvshow.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.bajpsubmission.databinding.FragmentDetailTvShowBinding

class DetailTVShowFragment : Fragment() {

    private lateinit var binding: FragmentDetailTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(activity).application
        val tvShow = DetailTVShowFragmentArgs.fromBundle(requireArguments()).detailTvShow
        val viewModelFactory = DetailTvShowViewModelFactory(tvShow, application)
        val detailTvShowViewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(DetailTvShowViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailTvShowViewModel
        binding.toolbarDetailTvShow.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}
