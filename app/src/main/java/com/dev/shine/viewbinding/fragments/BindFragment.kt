package com.dev.shine.viewbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.dev.shine.viewbinding.R
import com.dev.shine.viewbinding.databinding.FragmentBlankBinding

class BindFragment : Fragment(R.layout.fragment_blank) {

    private var fragmentBindBinding: FragmentBlankBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBlankBinding.bind(view)
        fragmentBindBinding = binding
        binding.tvName.text = getString(R.string.bind_fragment)
    }

    override fun onDestroyView() {
        fragmentBindBinding = null
        super.onDestroyView()
    }
}