package com.example.shoppingapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.R
import com.example.shoppingapp.data.db.entities.ShoppingItem
import com.example.shoppingapp.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
        var items: List<ShoppingItem>,
        private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val currentPosition = items[position]

        holder.tvName.text = currentPosition.name
        holder.tvAmount.text = currentPosition.amount.toString()
        holder.deleteIcon.setOnClickListener {
            viewModel.delete(currentPosition)
        }
        holder.addIcon.setOnClickListener {
            currentPosition.amount++
            viewModel.upsert(currentPosition)
        }
        holder.minesIcon.setOnClickListener {

            if (currentPosition.amount > 0){
                currentPosition.amount--
                viewModel.upsert(currentPosition)
            }


        }
    }

    inner class ShoppingItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val deleteIcon: ImageView = itemView.findViewById(R.id.ic_delete)
        val addIcon: ImageView = itemView.findViewById(R.id.ic_plus)
        val minesIcon: ImageView = itemView.findViewById(R.id.ic_mines)

    }

}