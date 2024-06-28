package com.example.mysumatera

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysumatera.databinding.FragmentObjekWisataItemBinding
import com.example.mysumatera.placeholder.PlaceholderContent.PlaceholderItem


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyobjekwisataRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyobjekwisataRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentObjekWisataItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.setImageDrawable()
        holder.namaobjekView.text = item.id
        holder.ratingobjekView.text = item.id
        holder.biayaKunjunganObjekView.text = item.id
        holder.biayaPerjalananView.text = item.id
        holder.deskripsiobjekView.text = item.id
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentObjekWisataItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: ImageView = binding.gambarobjek
        val namaobjekView: TextView = binding.namaobjek
        val ratingobjekView: TextView = binding.ratingobjek
        val biayaKunjunganObjekView: TextView = binding.biayaKunjunganObjek
        val biayaPerjalananView: TextView = binding.biayaPerjalananObjek
        val deskripsiobjekView: TextView = binding.deskripsiobjek


        override fun toString(): String {
            return super.toString() + " '" + contentView + "'" + namaobjekView.text + "'" + ratingobjekView.text + "'" + biayaKunjunganObjekView.text + "'" + biayaPerjalananView.text + "'" + deskripsiobjekView.text
        }
    }

}

private fun ImageView.setImageDrawable() {
    var myImageView: ImageView? =
        findViewById(R.id.icon)
}
