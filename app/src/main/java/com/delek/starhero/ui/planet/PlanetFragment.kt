package com.delek.starhero.ui.planet

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
        return binding.root
    }

    private fun initUI() {

        val ship = data.getInt("ship", 0)
        viewModel.getShipById(ship)
        viewModel.ship.observe(viewLifecycleOwner) {
            val id = Util.getResId(it.image, R.drawable::class.java)
            binding.ivShip.setImageResource(id)
        }

        viewModel.getPlanetById(args.planetId)
        viewModel.planet.observe(viewLifecycleOwner) { planet ->
            binding.tvPlanet.text = planet.name
            val id = Util.getResId(planet.image, R.drawable::class.java)
            binding.ivPlanet.setImageResource(id)
            binding.ivShip.setOnClickListener {
                findNavController().navigate(
                    PlanetFragmentDirections.actionNavPlanetToNavStar(planet.starId)
                )
            }
        }

        viewModel.getDwellingByPlanet(args.planetId)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            if (dwelling != null) {
                val id = Util.getResId(dwelling.image, R.drawable::class.java)
                binding.ivDwelling.leftDrawable(id, R.dimen.icon_size)
                binding.tvDwelling.text = dwelling.name
                binding.ivPlanet.setOnClickListener {
                    findNavController().navigate(
                        PlanetFragmentDirections.actionNavPlanetToNavDwelling(
                            args.planetId,
                            dwelling.id
                        )
                    )
                }
            } else {
                binding.tvDwelling.background = null
                binding.ivPlanet.setOnClickListener {
                    findNavController().navigate(
                        PlanetFragmentDirections.actionNavPlanetToNavSurface(args.planetId)
                    )
                }
            }
        }
    }

    private fun TextView.leftDrawable(@DrawableRes id: Int = 0, @DimenRes sizeRes: Int) {
        val drawable = ContextCompat.getDrawable(context, id)
        val size = resources.getDimensionPixelSize(sizeRes)
        drawable?.setBounds(0, 0, size, size)
        this.setCompoundDrawables(null, drawable, null, null)
    }
}