package com.delek.starhero.ui.dwelling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.starhero.databinding.FragmentDwellingBinding
import com.delek.starhero.ui.dwelling.GroupAdapter.Companion.selected
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DwellingFragment : Fragment() {

    companion object {
        fun newInstance() = DwellingFragment()
    }

    private val viewModel: DwellingViewModel by viewModels()
    private var _binding: FragmentDwellingBinding? = null
    private val binding get() = _binding!!
    private val args: DwellingFragmentArgs by navArgs()
    private lateinit var groupAdapter: GroupAdapter
    private lateinit var nativeAdapter: NativeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDwellingBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewModel.getDwellingById(args.id)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            binding.dwellingName.text = dwelling.name
        }
        // Adapter Group
        groupAdapter = GroupAdapter(onItemSelected = {
            viewModel.getNativesByGroup(it.id)
            groupAdapter.updateList(viewModel.group.value!!)
        })
        binding.rvGroup.layoutManager = GridLayoutManager(context, 4)
        binding.rvGroup.adapter = groupAdapter
        // Adapter Natives
        nativeAdapter = NativeAdapter(onItemSelected = {
            nativeAdapter.updateList(viewModel.natives.value!!)
        })
        binding.rvNative.layoutManager = GridLayoutManager(context, 4)
        binding.rvNative.adapter = nativeAdapter
        // Update Adapters
        viewModel.getGroupByStart(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.group.observe(viewLifecycleOwner) { group ->
                    groupAdapter.updateList(group)
                    viewModel.getNativesByGroup(group[0].id)
                    viewModel.natives.observe(viewLifecycleOwner) { native ->
                        nativeAdapter.updateList(native)
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowBack.setOnClickListener {
            selected = 0
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}