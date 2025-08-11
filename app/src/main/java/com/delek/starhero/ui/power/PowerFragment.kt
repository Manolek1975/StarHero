package com.delek.starhero.ui.power

import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentPowerBinding
import com.delek.starhero.domain.model.Power
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.random.Random

@AndroidEntryPoint
class PowerFragment : Fragment() {

    private val viewModel: PowerViewModel by viewModels()
    private var _binding: FragmentPowerBinding? = null
    private val binding get() = _binding!!
    private val args: PowerFragmentArgs by navArgs()
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var powerAdapter: PowerAdapter
    private var numPowers: Int = 0
    private var countSpells = 0

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
        binding.ivCheck.setOnClickListener {
            val coords = randomStars()
            for (i in coords.indices) {
                viewModel.updatePosStar(coords[i].x, coords[i].y, i + 1)
            }
            findNavController().navigate(
                PowerFragmentDirections.actionPowerFragmentToStarsFragment()
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
            addSelectedPower(it, powerList)
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
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.hero.observe(viewLifecycleOwner) {
                    numPowers = it.numPowers
                    if (it.numPowers != 0) {
                        binding.selectedPower.text =
                            getString(R.string.selected_power, 0, numPowers)
                    } else {
                        binding.selectedPower.text = getString(R.string.no_powers)
                    }
                }
            }
        }
    }

    private fun addSelectedPower(it: Power, spellList: MutableList<Power>) {
        countSpells = spellList.count()
        if (countSpells < numPowers && !spellList.contains(it)) {
            spellList.add(it)
            countSpells = spellList.count() // Count again to refresh text
            binding.selectedPower.text = getString(R.string.selected_power, countSpells, numPowers)
            if (countSpells == numPowers) {
                binding.rvTypes.visibility = View.GONE
                binding.rvPowers.visibility = View.GONE
            }
            //Add Views to selected spells layout
            val view = TextView(context)
            view.text = spellList.last().name
            view.textSize = 20F
            binding.lyPowerLayout.addView(view)
            binding.lyPowerLayout.setOnClickListener {
                binding.lyPowerLayout.removeAllViews()
                spellList.clear()
                binding.rvTypes.visibility = View.VISIBLE
                binding.rvPowers.visibility = View.VISIBLE
                binding.selectedPower.text = getString(R.string.selected_power, 0, numPowers)
            }
        } else {
            Toast.makeText(
                context,
                getString(R.string.toast_already_power, it.name),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // Insert random coordinates to stars
    private fun randomStars(): MutableList<Point> {
        val random = Random
        val size = 20
        val dm = resources.displayMetrics
        val width = dm.widthPixels
        val height = dm.heightPixels
        val diameter = 200
        val radius = diameter * 0.5f
        val d2 = (diameter * diameter).toFloat()
        val coordinate : MutableList<Point> = ArrayList(size)

        val posX: MutableList<Float> = ArrayList(size)
        val posY: MutableList<Float> = ArrayList(size)
        while (posX.size < size) {
            // generate new coordinates
            val x: Float = random.nextInt(width - diameter) + radius
            val y: Float = random.nextInt(height - diameter) + radius
            // verify it does not overlap/touch with previous circles
            var j = 0
            while (j < posX.size) {
                val dx = posX[j] - x
                val dy = posY[j] - y
                val diffSquare = (dx * dx) + (dy * dy)
                if (diffSquare <= d2) break
                ++j
            }
            // generate another pair of coordinates, if it does touch previous
            if (j != posX.size) {
                //println("collided.")
                continue
            }
            //println("added.")
            // not overlapping/touch, add as new circle
            posX.add(x)
            posY.add(y)
            coordinate.add(Point(x.toInt(),y.toInt()))
        }
        return coordinate
    }

}