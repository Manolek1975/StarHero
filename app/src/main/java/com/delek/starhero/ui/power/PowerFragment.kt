package com.delek.starhero.ui.power

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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
        //initPower()
        initListeners()
    }

    private fun initListeners() {
        binding.ivCancel.setOnClickListener {
            findNavController().navigate(
                PowerFragmentDirections.actionPowerFragmentToNavDetail(args.heroId)
            )
        }
    }

/*    private fun initPower() {
        var typeId: Int
        val spellList = mutableListOf<Power>()
        viewModel.getHeroById(args.heroId)
        viewModel.getStartSpellTypes(args.id)
        typeAdapter = TypeAdapter(onItemSelected = {
            typeId = it.typeId
            viewModel.getSpellsByType(typeId)
            typeAdapter.updateTypes(viewmodel.spellType.value!!)
        })
        binding.rvTypes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTypes.adapter = typeAdapter

        spellAdapter = SpellAdapter(onItemSelected = {
            addSelectedSpells(it, spellList)
        })
        binding.rvSpells.layoutManager = GridLayoutManager(context, 4)
        binding.rvSpells.adapter = spellAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.role.observe(viewLifecycleOwner) {
                    numSpells = it.spells
                    if (it.spells != 0) {
                        binding.selectedSpells.text = getString(R.string.selected_spells, 0, numSpells)
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spellType.observe(viewLifecycleOwner) {
                    typeAdapter.updateTypes(it)
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spell.observe(viewLifecycleOwner) {
                    spellAdapter.updateSpells(it)
                }
            }
        }
    }*/

}