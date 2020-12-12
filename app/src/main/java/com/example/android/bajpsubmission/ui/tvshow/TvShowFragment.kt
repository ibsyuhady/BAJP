package com.example.android.bajpsubmission.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android.bajpsubmission.databinding.FragmentTvShowBinding
import com.example.android.bajpsubmission.utils.ViewModelFactory
import com.example.android.bajpsubmission.utils.adapters.TvShowAdapter
import com.example.android.bajpsubmission.utils.hide
import com.example.android.bajpsubmission.utils.show

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding
    private val viewModel by viewModels<TvShowViewModel> {
        ViewModelFactory.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        loadTvShow()
        onClickListener()
    }

    private fun loadTvShow() {
        binding.pbTvShow.show()
        binding.tvLoading.show()
        viewModel.getListTvShow().observe(
            viewLifecycleOwner,
            {
                binding.pbTvShow.hide()
                binding.tvLoading.hide()
            }
        )
    }

    private fun onClickListener() {
        binding.rvTvShow.adapter = TvShowAdapter(
            TvShowAdapter.OnClickListener {
                this.findNavController()
                    .navigate(
                        TvShowFragmentDirections.actionNavigationTvShowToNavigationDetailTvShow(it)
                    )
            }
        )
    }
}
