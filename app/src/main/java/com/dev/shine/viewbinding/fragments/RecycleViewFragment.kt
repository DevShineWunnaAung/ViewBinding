package com.dev.shine.viewbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.shine.viewbinding.adapter.RecycleViewAdapter
import com.dev.shine.viewbinding.databinding.FragmentRecycleViewBinding
import com.dev.shine.viewbinding.model.MainItem


class RecycleViewFragment : Fragment() {

    private var fragmentRecycleViewBinding: FragmentRecycleViewBinding? = null
    private val binding get() = fragmentRecycleViewBinding!!
    private lateinit var mData: List<MainItem>
    private lateinit var recycleViewAdapter: RecycleViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentRecycleViewBinding = FragmentRecycleViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        recycleViewAdapter = RecycleViewAdapter(view.context, mData)
        binding.rvHome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvHome.adapter = recycleViewAdapter
    }

    private fun loadData() {
        mData = listOf(
            MainItem("Brady"),
            MainItem("Flynn"),
            MainItem("Mills"),
            MainItem("Whittle"),
            MainItem("Gibbs"),
            MainItem("White"),
            MainItem("Edwards"),
            MainItem("Tate"),
            MainItem("Strickland"),
            MainItem("Nelson"),
        )
    }

    override fun onDestroyView() {
        fragmentRecycleViewBinding = null
        super.onDestroyView()
    }

}