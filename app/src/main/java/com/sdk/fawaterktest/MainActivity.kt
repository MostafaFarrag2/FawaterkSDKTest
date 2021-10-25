package com.sdk.fawaterktest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sdk.fawaterk.model.CartItems
import com.sdk.fawaterk.model.Customer
import com.sdk.fawaterk.model.InvoiceModel

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    var btDirectPayment: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btDirectPayment=findViewById(R.id.btDirectPayment)

            btDirectPayment?.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btDirectPayment -> {
                Toast.makeText(this, "back button pressed", Toast.LENGTH_SHORT).show()
                val cartItems =  CartItems("mostafa", 1, 20.0) ;
                val customer = Customer("mostafa", "farrag", "mo@g.com", "kommm", 122323)
                val arrayList = ArrayList<CartItems>()
                arrayList.add(cartItems);
                val customerList = ArrayList<Customer>()
                customerList.add(customer);

                val invoiceModel = InvoiceModel(
                    "85d4811d7956bc526c5130bf53c5b963f274e4381a9ba552b0",
                    arrayList,
                    20.0,
                    40.0,
                    customerList,
                    "www.facebook.com",
                    "EGP",
                    true,
                    true,
                    "ftest"
                )

            }
            else -> {
            }
    }
}
}