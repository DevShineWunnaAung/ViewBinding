package com.dev.shine.viewbinding.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.dev.shine.viewbinding.databinding.CustomDialogBinding
import com.dev.shine.viewbinding.databinding.ListItemBinding
import com.dev.shine.viewbinding.model.MainItem

class RecycleViewAdapter(private var mContext: Context, private var mData: List<MainItem>) : RecyclerView.Adapter<RecycleViewAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(holder){
            with(mData[position]){
                val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
                binding.ivProfile.setBackgroundColor(color)
                binding.tvName.text = this.name
                binding.rlItem.setOnClickListener{
                    val customDialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(mContext))
                    val dialog = Dialog(mContext)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setCancelable(true)
                    dialog.setContentView(customDialogBinding.root)
                    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    customDialogBinding.llHome.setBackgroundColor(color)
                    customDialogBinding.tvDialogName.text = this.name
                    customDialogBinding.btnClose.setOnClickListener { dialog.dismiss() }
                    dialog.show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}