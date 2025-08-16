package com.delek.starhero.ui.star

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.starhero.databinding.FragmentStarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarFragment : Fragment() {

    private val viewModel: StarViewModel by viewModels()
    private var _binding: FragmentStarBinding? = null
    private val binding get() = _binding!!
    private val args: StarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarBinding.inflate(inflater, container, false)

        viewModel.getStarById(args.starId)
        viewModel.star.observe(viewLifecycleOwner) {
            binding.tvStar.text = it.name
        }

        return binding.root
    }
}