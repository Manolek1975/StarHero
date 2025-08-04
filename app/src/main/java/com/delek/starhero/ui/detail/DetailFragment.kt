package com.delek.starhero.ui.detail


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
import androidx.navigation.fragment.navArgs
import com.delek.starhero.R
import com.delek.starhero.core.Util
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
        viewModel.getHeroById(args.heroId)
        viewModel.hero.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
            binding.tvSize.text = getString(R.string.size, it.size)
            val id = Util.getResId(it.image, R.drawable::class.java)
            binding.ivHero.setImageResource(id)
            binding.stats.strength.text = String.format("%s", it.strength)
            binding.stats.defense.text = String.format("%s", it.defense)
            binding.stats.health.text = String.format("%s", it.health)
            binding.stats.speed.text = String.format("%s", it.speed)
            binding.stats.power.text = String.format("%s", it.power)
            viewModel.getSkillById(it.skill)
            viewModel.skill.observe(viewLifecycleOwner){ skill ->
                binding.tvSkill.text = getString(R.string.skill, skill.name)
                //val skillId = Util.getResId(it.image, R.drawable::class.java)
                //binding.ivSkill.leftDrawable(skillId, R.dimen.icon_size)
            }
            viewModel.getWeaponById(it.weapon)
            viewModel.weapon.observe(viewLifecycleOwner) { weapon ->
                binding.ivWeapon.text = getString(R.string.weapon_detail, weapon.name, weapon.type)
                val weaponId = Util.getResId(weapon.image, R.drawable::class.java)
                binding.ivWeapon.leftDrawable(weaponId, R.dimen.icon_size)
            }
            viewModel.getShipById(it.ship)
            viewModel.ship.observe(viewLifecycleOwner) { ship ->
                binding.ivShip.text = ship.name
                val shipId = Util.getResId(ship.image, R.drawable::class.java)
                binding.ivShip.leftDrawable(shipId, R.dimen.icon_size)
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