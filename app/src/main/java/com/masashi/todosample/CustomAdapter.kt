package com.masashi.todosample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Masashi Hamaguchi on 2022/01/29.
 */

class CustomAdapter(
    private var customClassList: MutableList<Task>?
) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.CustomViewHolder, position: Int) {
        val item: Task = customClassList?.get(position) ?: return

        holder.titleText.text = item.title
        holder.memoText.text = item.memo
    }

    override fun getItemCount(): Int = customClassList?.size ?: 0

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.titleText)
        val memoText: TextView = view.findViewById(R.id.memoText)
    }
}
