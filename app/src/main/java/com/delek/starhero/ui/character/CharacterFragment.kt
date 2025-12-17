package com.delek.starhero.ui.character

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    companion object {
        fun newInstance() = CharacterFragment()
    }

    private val viewModel: CharacterViewModel by viewModels()
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.tvHeroName.text = "Amazon"
        binding.ivHeroImage.setImageResource(R.drawable.h_amazon)
        binding.ivHead.setImageResource(R.drawable.t_101)
        binding.ivNeck.setImageResource(R.drawable.t_101)

    }
}