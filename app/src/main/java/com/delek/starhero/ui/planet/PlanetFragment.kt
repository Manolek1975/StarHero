package com.delek.starhero.ui.planet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.FragmentPlanetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetFragment : Fragment() {

    private val viewModel: PlanetViewModel by viewModels()
    private var _binding: FragmentPlanetBinding? = null
    private val binding get() = _binding!!
    private val args: PlanetFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)

        viewModel.getPlanetById(args.planetId)
        viewModel.planet.observe(viewLifecycleOwner) { planet ->
            binding.tvPlanet.text = planet.name
            val id = Util.getResId(planet.image, R.drawable::class.java)
            binding.ivPlanet.setImageResource(id)
        }

        return binding.root
    }
}