package com.example.android.bajpsubmission.ui.tvshow.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.android.bajpsubmission.databinding.FragmentDetailTvShowBinding

class DetailTVShowFragment : Fragment() {

    private lateinit var binding: FragmentDetailTvShowBinding
    private val detailTvShowViewModel by viewModels<DetailTvShowViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvShow = DetailTVShowFragmentArgs.fromBundle(requireArguments()).detailTvShow
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailTvShowViewModel
        detailTvShowViewModel.getDetailTvShow(tvShow)
        binding.toolbarDetailTvShow.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}
