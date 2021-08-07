package com.example.shoppingapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingapp.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)

abstract class ShoppingDatabase: RoomDatabase() {

    //for accessing to the DAO class
    abstract fun getShoppingDao(): ShoppingDao

    //like static key in java and use it for implement Singleton design pattern
    companion object{

        //this means that just one thread has to instantiate the instance variable
        @Volatile
        private var instance: ShoppingDatabase? = null

        private val BLOCK = Any()

        //when create ShoppingDatabase class this will create and
        // return instance and if block the other threads to avoid them to instantiate it
        operator fun invoke(context: Context) = instance
            ?: synchronized(BLOCK){
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it }
        }
        //to make the Database
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context, ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}