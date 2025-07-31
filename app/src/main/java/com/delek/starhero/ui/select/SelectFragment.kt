package com.delek.starhero.ui.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentSelectBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SelectFragment : Fragment() {

    private var _binding: FragmentSelectBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SelectViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        binding.textSelect.text = getString(R.string.head)
        val adapter = SelectAdapter(onItemclickListener = {
            findNavController().navigate(
                SelectFragmentDirections.actionNavSelectToNavDetail(it.id)
            )
        })
        binding.rvHeroes.layoutManager = GridLayoutManager(context, 2)
        binding.rvHeroes.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.heroes.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}