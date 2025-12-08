package com.delek.starhero.ui.surface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.FragmentSurfaceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SurfaceFragment : Fragment() {

    companion object {
        fun newInstance() = SurfaceFragment()
    }

    private val viewModel: SurfaceViewModel by viewModels()
    private var _binding: FragmentSurfaceBinding? = null
    private val binding get() = _binding!!
    private val args: SurfaceFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurfaceBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewModel.getPlanetById(args.planetId)
        viewModel.planet.observe(viewLifecycleOwner) {
            val id = Util.getResId(it.surface, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            binding.tvPlanet.text = it.name
        }

        viewModel.getDwellingByPlanet(args.planetId)
        viewModel.dwelling.observe(viewLifecycleOwner) {
            if (it != null) {
                val id = Util.getResId(it.image, R.drawable::class.java)
                binding.ivDwelling.setImageResource(id)
                binding.tvDwelling.text = it.name
            }
        }

/*        binding.skill1.text = "AUTO\nATTACK"
        binding.skill2.text = "FEIGN\nDEAD"
        binding.skill3.text = "BERSERK"
        binding.skill4.text = "HIDE"*/

        binding.ivDwelling.setOnClickListener {
            findNavController().navigate(
                SurfaceFragmentDirections.actionNavSurfaceToNavDwelling(1)
            )
        }

    }

}