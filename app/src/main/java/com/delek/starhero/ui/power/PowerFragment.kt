package com.delek.starhero.ui.power

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentPowerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PowerFragment : Fragment() {

    private val viewModel: PowerViewModel by viewModels()
    private var _binding: FragmentPowerBinding? = null
    private val binding get() = _binding!!
    private val args: PowerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPowerBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        initSkill()
        initPower()
        initListeners()
    }

    private fun initListeners() {
        binding.ivCancel.setOnClickListener {
            findNavController().navigate(
                PowerFragmentDirections.actionPowerFragmentToNavDetail(args.heroId)
            )
        }
    }

    private fun initSkill() {
        viewModel.getHeroById(args.heroId)
        viewModel.hero.observe(viewLifecycleOwner) {
            binding.headPower.text = it.name
            viewModel.getSkillById(args.heroId)
            viewModel.skill.observe(viewLifecycleOwner) { skill ->
                binding.headSkill.text = getString(R.string.skill, skill.name)
            }
        }

    }

    private fun initPower() {
        //TODO("Not yet implemented")
    }
}