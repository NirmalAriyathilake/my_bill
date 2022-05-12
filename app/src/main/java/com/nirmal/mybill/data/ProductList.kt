package com.nirmal.mybill.data

import com.nirmal.mybill.domain.Product

class ProductList {
    private val data = mapOf(
        "1" to Product(
            name = "Big Brekkie",
            price = 16.0,
            tax = 10.0,
        ),
        "2" to Product(
            name = "Bruschetta",
            price = 8.0,
            tax = 10.0,
        ),
        "3" to Product(
            name = "Poached Eggs",
            price = 12.0,
            tax = 10.0,
        ),
        "4" to Product(
            name = "Coffee",
            price = 3.0,
            tax = 0.0,
        ),
        "5" to Product(
            name = "Tea",
            price = 3.0,
            tax = 0.0,
        ),
        "6" to Product(
            name = "Soda",
            price = 4.0,
            tax = 5.0,
        ),
        "7" to Product(
            name = "Garden Salad",
            price = 10.0,
            tax = 5.0,
        ),
    )

    fun get(index: String): Product = data[index] ?: Product(name = "", price = 0.0, tax = 0.0)
}