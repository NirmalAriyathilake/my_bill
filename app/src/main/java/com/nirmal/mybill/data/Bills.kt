package com.nirmal.mybill.data

import com.nirmal.mybill.domain.BillDetails
import com.nirmal.mybill.domain.PurchasedItem

object Bills {
    val data = listOf(
        BillDetails(
            groupName = "Group 1",
            count = 3,
            transactions = listOf("individual", "full"),
            items = listOf(
                listOf(
                    PurchasedItem(
                        product = ProductList().get("1"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("2"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("3"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("4"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("6"),
                        count = 1,
                    )
                ),
                listOf(
                    PurchasedItem(
                        product = ProductList().get("1"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("2"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("3"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("4"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("6"),
                        count = 1,
                    )
                ),
                listOf(
                    PurchasedItem(
                        product = ProductList().get("1"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("2"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("3"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("5"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("6"),
                        count = 1,
                    )
                ),
            ),
        ),
        BillDetails(
            groupName = "Group 2",
            count = 5,
            transactions = listOf("single", "credit"),
            discount = "10%",
            items = listOf(
                listOf(
                    PurchasedItem(
                        product = ProductList().get("5"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("4"),
                        count = 3,
                    ),
                    PurchasedItem(
                        product = ProductList().get("1"),
                        count = 3,
                    ),
                    PurchasedItem(
                        product = ProductList().get("3"),
                        count = 1,
                    ),
                    PurchasedItem(
                        product = ProductList().get("7"),
                        count = 1,
                    ),
                )
            )
        ),
        BillDetails(
            groupName = "Group 3",
            count = 5,
            transactions = listOf("$50", "split", "full"),
            discount = "$25",
            items = listOf(
                listOf(
                    PurchasedItem(
                        product = ProductList().get("5"),
                        count = 2,
                    ),
                    PurchasedItem(
                        product = ProductList().get("4"),
                        count = 3,
                    ),
                    PurchasedItem(
                        product = ProductList().get("6"),
                        count = 2,
                    ),
                    PurchasedItem(
                        product = ProductList().get("2"),
                        count = 5,
                    ),
                    PurchasedItem(
                        product = ProductList().get("1"),
                        count = 5,
                    ),
                    PurchasedItem(
                        product = ProductList().get("3"),
                        count = 2,
                    ),
                    PurchasedItem(
                        product = ProductList().get("7"),
                        count = 3,
                    ),
                )
            )
        )
    )
}