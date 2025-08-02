package com.delek.starhero.ui.detail


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.starhero.R
import com.delek.starhero.data.core.Util
import com.delek.starhero.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {

        val view = ImageView(context)
        view.setImageResource(R.drawable.ic_dot)
        viewModel.getHeroById(args.heroId)
        viewModel.hero.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
            binding.tvSize.text = getString(R.string.size, it.size)
            binding.tvSkill.text = getString(R.string.skill, it.skill.toString())
            val id = Util.getResId(it.icon, R.drawable::class.java)
            binding.ivHero.setImageResource(id)
            binding.stats.strength.text = String.format("%s", it.strength)
            binding.stats.defense.text = String.format("%s", it.defense)
            binding.stats.health.text = String.format("%s", it.health)
            binding.stats.speed.text = String.format("%s", it.speed)
            binding.stats.power.text = String.format("%s", it.power)

            viewModel.getWeaponById(it.weapon)
            viewModel.weapon.observe(viewLifecycleOwner) { weapon ->
                binding.tvWeapon.text = String.format("%s", weapon.name)
                val weaponId = Util.getResId(weapon.image, R.drawable::class.java)
                val bitmap = BitmapFactory.decodeResource(resources, weaponId)
                val scale = Bitmap.createScaledBitmap(bitmap, 200, 200, false)
                val image = BitmapDrawable(resources, scale)
                binding.ivWeapon.background = image

            }



        }

    }
}