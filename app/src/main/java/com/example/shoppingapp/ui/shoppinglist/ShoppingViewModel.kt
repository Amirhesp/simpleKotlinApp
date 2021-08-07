package com.example.shoppingapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.db.entities.ShoppingItem
import com.example.shoppingapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel(){


    // we do not use suspend cause we'll use Coroutine
    //Dispatcher is used as Coroutine context and IO is for db but Room will handle and we use Main and default context is for
    //long and complex operation
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    //its just read operation and we dont need to use Coroutine
    fun getAllShoppingItems() = repository.getAllShoppingItem()
}