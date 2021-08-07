package com.example.shoppingapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingapp.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingList(): LiveData<List<ShoppingItem>>
}