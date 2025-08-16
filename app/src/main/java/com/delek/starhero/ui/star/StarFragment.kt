package com.delek.starhero.ui.star

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.delek.starhero.databinding.FragmentStarBinding

class StarFragment : Fragment() {

    private val viewModel: StarViewModel by viewModels()
    private var _binding: FragmentStarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarBinding.inflate(inflater, container, false)

        return binding.root
    }
}