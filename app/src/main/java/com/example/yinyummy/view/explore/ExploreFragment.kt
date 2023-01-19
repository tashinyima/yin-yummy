package com.example.yinyummy.view.explore

import android.os.Bundle
import android.util.Log
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
import com.example.yinyummy.adapter.ExploreCategoryAdapter
import com.example.yinyummy.databinding.FragmentExploreBinding
import com.example.yinyummy.viewmodel.CategoryViewModel
import com.example.yinyummy.viewmodel.ExploreViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG ="ExploreFragment"
@AndroidEntryPoint
class ExploreFragment : Fragment() {


    private val viewModelCategory : CategoryViewModel by viewModels()
    private val viewModelPopular: ExploreViewModel by viewModels()
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var exploreAdapter: ExploreAdapter
    private lateinit var categoryAdapter: ExploreCategoryAdapter

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
        fetchCategories()
        handleItemOnClick()

    }

    private fun fetchCategories() {
        viewModelCategory.loadCategories()
        viewModelCategory.categoriesLiveData.observe(viewLifecycleOwner,{
            Log.d(TAG,it.toString())
            categoryAdapter.updateResult(it)
        })
    }

    private fun handleItemOnClick() {
        exploreAdapter.onItemClick = {
            val bundle = bundleOf("result" to it.id)
            findNavController().navigate(R.id.action_exploreFragment_to_detailFragment, bundle)
        }
    }

    private fun fetchPopularData() {
        viewModelPopular.loadResult()
        viewModelPopular.resultLiveData.observe(viewLifecycleOwner, { result ->
            exploreAdapter.updateResult(result)
        })
    }


    private fun initRecycler() {
        exploreAdapter = ExploreAdapter(ArrayList())
        categoryAdapter = ExploreCategoryAdapter(ArrayList())
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = categoryAdapter
        }

        binding.rvPopularChoice.apply {
            layoutManager =LinearLayoutManager(context)
            adapter = exploreAdapter
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}