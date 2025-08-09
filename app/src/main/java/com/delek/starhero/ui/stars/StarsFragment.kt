package com.delek.starhero.ui.stars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.delek.starhero.databinding.FragmentStarsBinding

class StarsFragment : Fragment() {

    private var _binding: FragmentStarsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val map = DrawStars(requireContext())
        binding.map.addView(map)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}