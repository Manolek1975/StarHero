package com.delek.starhero.ui.planet

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        initUI()
/*            binding.ivDwelling.setOnClickListener {
                println("Dwelling: " + dwelling.id)
                findNavController().navigate(
                    SurfaceFragmentDirections.actionNavSurfaceToNavDwelling(dwelling.id)
                )
            }*/
        return binding.root
    }

    private fun initUI() {
        viewModel.getPlanetById(args.planetId)
        viewModel.planet.observe(viewLifecycleOwner) { planet ->
            binding.tvPlanet.text = planet.name
            val id = Util.getResId(planet.image, R.drawable::class.java)
            binding.ivPlanet.setImageResource(id)
            binding.ivPlanet.setOnClickListener {
                findNavController().navigate(
                    PlanetFragmentDirections.actionNavPlanetToNavSurface(planet.id)
                )
            }
        }

        viewModel.getDwellingByPlanet(args.planetId)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            if (dwelling != null) {
                val id = Util.getResId(dwelling.image, R.drawable::class.java)
                binding.ivDwelling.leftDrawable(id, R.dimen.icon_size)
                binding.ivDwelling.text = dwelling.name
                binding.ivPlanet.setOnClickListener {
                    findNavController().navigate(
                        PlanetFragmentDirections.actionNavPlanetToNavDwelling(dwelling.id)
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