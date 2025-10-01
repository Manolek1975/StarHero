package com.delek.starhero.ui.star

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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.FragmentStarBinding
import com.delek.starhero.ui.select.SelectFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StarFragment : Fragment() {

    private val viewModel: StarViewModel by viewModels()
    private var _binding: FragmentStarBinding? = null
    private val binding get() = _binding!!
    private val args: StarFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarBinding.inflate(inflater, container, false)

        viewModel.getStarById(args.starId)
        viewModel.star.observe(viewLifecycleOwner) { star ->
            binding.ivStar.text = star.name
            val id = Util.getResId(star.image, R.drawable::class.java)
            binding.ivStar.leftDrawable(id, R.dimen.icon_size)
        }

        val adapter = PlanetAdapter(onItemClickListener = {
            findNavController().navigate(
                SelectFragmentDirections.actionNavSelectToNavDetail(it.id)
            )
        })
        binding.rvPlanets.layoutManager = LinearLayoutManager(context)
        binding.rvPlanets.adapter = adapter
        viewModel.getPlanetsByStarId(args.starId)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.planets.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }

        return binding.root
    }

    private fun TextView.leftDrawable(@DrawableRes id: Int = 0, @DimenRes sizeRes: Int) {
        val drawable = ContextCompat.getDrawable(context, id)
        val size = resources.getDimensionPixelSize(sizeRes)
        drawable?.setBounds(0, 0, size, size)
        this.setCompoundDrawables(drawable, null, null, null)
    }
}