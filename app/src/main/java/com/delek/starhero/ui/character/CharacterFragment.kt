package com.delek.starhero.ui.character

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    companion object {
        fun newInstance() = CharacterFragment()
    }

    private val viewModel: CharacterViewModel by viewModels()
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
        return binding.root
    }

    private fun initUI() {

        // TEST OJO only in fragment TRADE
/*        val heroItem = HeroItemEntity(0, 2, 0)
        viewModel.insertHeroItem(heroItem)*/

        val heroId = data.getInt("hero", 0)
        viewModel.getHeroById(heroId)
        viewModel.hero.observe(viewLifecycleOwner) {
            binding.tvHeroName.text = it.name
            val id = Util.getResId(it.image, R.drawable::class.java)
            binding.ivHeroImage.setImageResource(id)
        }


        binding.ivWeapon.setImageResource(R.drawable.tw_101)
        //binding.ivHead.leftDrawable(R.drawable.t_101, R.dimen.icon_size)

    }

}