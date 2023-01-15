package com.example.yinyummy.view.explore

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yinyummy.R
import com.example.yinyummy.adapter.ExploreAdapter
import com.example.yinyummy.databinding.FragmentExploreBinding
import com.example.yinyummy.viewmodel.ExploreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private val viewModel: ExploreViewModel by viewModels()
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var exploreAdapter: ExploreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        fetchPopularData()
        handleItemOnClick()

    }

    private fun handleItemOnClick() {
        exploreAdapter.onItemClick = {
            val bundle = bundleOf("result" to it.id)
            findNavController().navigate(R.id.action_exploreFragment_to_detailFragment, bundle)
        }
    }

    private fun fetchPopularData() {
        viewModel.loadResult()
        viewModel.resultLiveData.observe(viewLifecycleOwner, { result ->
            exploreAdapter.updateResult(result)
        })
    }

    private fun initRecycler() {
        exploreAdapter = ExploreAdapter(ArrayList())
        binding.popularRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exploreAdapter
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}