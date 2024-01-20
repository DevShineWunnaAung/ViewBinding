package com.dev.shine.viewbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.shine.viewbinding.R
import com.dev.shine.viewbinding.databinding.FragmentBlankBinding

class InflateFragment : Fragment() {

    private var fragmentInflateBinding: FragmentBlankBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBlankBinding.inflate(inflater, container, false)
        fragmentInflateBinding = binding
        binding.tvName.text = getString(R.string.inflate_fragment)
        return binding.root
    }

    override fun onDestroyView() {
        fragmentInflateBinding = null
        super.onDestroyView()
    }

}