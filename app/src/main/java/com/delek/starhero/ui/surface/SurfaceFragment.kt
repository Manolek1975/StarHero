package com.delek.starhero.ui.surface

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSurfaceBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
        return binding.root
    }

    private fun initUI() {
        initHead()
        initMonster()
        initActionButtons()
    }

    private fun initHead() {
        viewModel.getPlanetById(args.planetId)
        viewModel.planet.observe(viewLifecycleOwner) { planet ->
            val id = Util.getResId(planet.surface, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            binding.tvPlanet.text = planet.name
        }
    }

    private fun initMonster() {
        binding.ivMonster.setImageResource(R.drawable.m_102)
        binding.tvMonster.text = "Antmen"
    }

    private fun initActionButtons() {
        binding.ivAttack.text = getString(R.string.attack)
        binding.ivSkill.text =  getString(R.string.skill)
        binding.ivSkill2.text = getString(R.string.hide)
        binding.ivSkill3.text = getString(R.string.run)
        binding.ivSkill4.text = getString(R.string.use)
        binding.ivAttack.setOnClickListener {
            binding.ivAttack.blink()
            combat()
        }

    }

    private fun combat() {
        val hero = data.getInt("hero", 0)
        viewModel.getHeroById(hero)
        viewModel.hero.observe(viewLifecycleOwner) { hero ->
            val str = hero.strength
            println(str)
            viewModel.getMonsterById(1)
            viewModel.monster.observe(viewLifecycleOwner) { monster ->
                val def = monster.armor
                println(def)
            }
        }

    }

    private fun View.blink(
        times: Int = 10,
        duration: Long = 100L,
        offset: Long = 20L,
        minAlpha: Float = 0.0f,
        maxAlpha: Float = 1.0f,
        repeatMode: Int = Animation.ABSOLUTE
    ) {
        startAnimation(AlphaAnimation(minAlpha, maxAlpha).also {
            it.duration = duration
            it.startOffset = offset
            it.repeatMode = repeatMode
            it.repeatCount = times
        })
    }



}