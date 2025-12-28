package com.delek.starhero.ui.trade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentTradeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TradeFragment : Fragment() {

    companion object {
        fun newInstance() = TradeFragment()
    }

    private val viewModel: TradeViewModel by viewModels()
    private var _binding: FragmentTradeBinding? = null
    private val binding get() = _binding!!
    private val args: TradeFragmentArgs by navArgs()
    private lateinit var adapter: TradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTradeBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewModel.getGroupById(args.groupId)
        viewModel.group.observe(viewLifecycleOwner) { group ->
            binding.tvNativeName.text = group.name
        }
        viewModel.getTreasures()
        adapter = TradeAdapter(onItemClickListener = {
            showBuyDialog(it.name)
        })
        binding.rvItems.layoutManager = LinearLayoutManager(context)
        binding.rvItems.adapter = adapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.treasures.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }
    }

    private fun showBuyDialog(name: String){
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AlertDialogStyle)
        dialogBuilder.setIcon(android.R.drawable.stat_sys_warning)
        dialogBuilder.setTitle(name)
        dialogBuilder.setMessage("Want to buy this item?")
        dialogBuilder.setNegativeButton("OK") { _, _ -> }.show()
    }

}
