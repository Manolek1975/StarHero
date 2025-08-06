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
import androidx.navigation.fragment.findNavController
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
        initHero()
        initNatives(args.heroId)
        initListeners()
    }

    private fun initHero() {
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
            viewModel.skill.observe(viewLifecycleOwner) { skill ->
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

    private fun initNatives(id: Int) {
        viewModel.getAllyNatives(id)
        viewModel.allyNatives.observe(viewLifecycleOwner) {
            val ally: MutableList<String> = mutableListOf()
            for (i in it) ally.add(i.name)
            if (ally.isEmpty()) binding.tvAlly.visibility = View.GONE
            binding.tvAlly.text = ally.joinToString(prefix = "ALLY: ", separator = ", ")
        }
        viewModel.getFriendlyNatives(id)
        viewModel.friendlyNatives.observe(viewLifecycleOwner) {
            val friend: MutableList<String> = mutableListOf()
            for (i in it) friend.add(i.name)
            if (friend.isEmpty()) binding.tvFriendly.visibility = View.GONE
            binding.tvFriendly.text = friend.joinToString(prefix = "FRIENDLY: ", separator = ", ")
        }
        viewModel.getUnfriendlyNatives(id)
        viewModel.unfriendlyNatives.observe(viewLifecycleOwner) {
            val unfriend: MutableList<String> = mutableListOf()
            for (i in it) unfriend.add(i.name)
            if (unfriend.isEmpty()) binding.tvUnfriendly.visibility = View.GONE
            binding.tvUnfriendly.text = unfriend.joinToString(prefix = "UNFRIENDLY: ", separator = ", ")
        }
        viewModel.getEnemyNatives(id)
        viewModel.enemyNatives.observe(viewLifecycleOwner) {
            val enemy: MutableList<String> = mutableListOf()
            for (i in it) enemy.add(i.name)
            if (enemy.isEmpty()) binding.tvEnemy.visibility = View.GONE
            binding.tvEnemy.text = enemy.joinToString(prefix = "ENEMY: ", separator = ", ")
        }
    }

    private fun initListeners() {
        binding.ivCancel.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionNavDetailToNavSelect()
            )
        }
        /*        binding.ivCheck.setOnClickListener {
                    findNavController().navigate(
                        DetailFragmentDirections.actionNavDetailToNavOptions(args.id)
                    )
                }*/
    }

    private fun TextView.leftDrawable(@DrawableRes id: Int = 0, @DimenRes sizeRes: Int) {
        val drawable = ContextCompat.getDrawable(context, id)
        val size = resources.getDimensionPixelSize(sizeRes)
        drawable?.setBounds(0, 0, size, size)
        this.setCompoundDrawables(null, drawable, null, null)
    }


}