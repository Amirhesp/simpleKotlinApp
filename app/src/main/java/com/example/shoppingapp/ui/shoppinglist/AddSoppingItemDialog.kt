package com.example.shoppingapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingapp.R
import com.example.shoppingapp.data.db.entities.ShoppingItem

class AddSoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val tvAdd: TextView? = findViewById(R.id.tvAdd)
        val tvCancel: TextView? = findViewById(R.id.tvCancel)
        val edAmount: EditText? = findViewById(R.id.edAmount)
        val edName: EditText? = findViewById(R.id.edName)
        tvAdd?.setOnClickListener{

            val name = edName?.text.toString()
            val amount = edAmount?.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "لطفا مقادیر مناسب را وارد کنید", Toast.LENGTH_LONG).show()
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel?.setOnClickListener{
            cancel()
        }


    }
}