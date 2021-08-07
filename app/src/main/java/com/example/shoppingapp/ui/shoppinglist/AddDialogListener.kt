package com.example.shoppingapp.ui.shoppinglist

import com.example.shoppingapp.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}