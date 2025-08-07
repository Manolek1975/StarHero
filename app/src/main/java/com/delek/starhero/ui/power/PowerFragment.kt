package com.delek.starhero.ui.power

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.starhero.databinding.FragmentPowerBinding
import com.delek.starhero.domain.model.Power
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PowerFragment : Fragment() {

    private val viewModel: PowerViewModel by viewModels()
    private var _binding: FragmentPowerBinding? = null
    private val binding get() = _binding!!
    private val args: PowerFragmentArgs by navArgs()
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var powerAdapter: PowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPowerBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
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

    private fun initPower() {
        var typeId: Int
        val powerList = mutableListOf<Power>()
        viewModel.getHeroById(args.heroId)
        viewModel.getStartPowerTypes(args.heroId)

        typeAdapter = TypeAdapter(onItemSelected = {
            typeId = it.typeId
            viewModel.getPowerByType(typeId)
            typeAdapter.updateTypes(viewModel.powerType.value!!)
        })
        binding.rvTypes.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvTypes.adapter = typeAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.powerType.observe(viewLifecycleOwner) {
                    typeAdapter.updateTypes(it)
                }
            }
        }

        powerAdapter = PowerAdapter(onItemSelected = {
            //addSelectedSpells(it, spellList)
        })
        binding.rvPowers.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvPowers.adapter = powerAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.power.observe(viewLifecycleOwner) {
                    powerAdapter.updatePowers(it)
                }
            }
        }

        /*        lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.role.observe(viewLifecycleOwner) {
                            numSpells = it.spells
                            if (it.spells != 0) {
                                binding.selectedSpells.text =
                                    getString(R.string.selected_spells, 0, numSpells)
                            }
                        }
                    }
                }*/
    }

}