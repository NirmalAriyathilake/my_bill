package com.nirmal.mybill.domain

data class BillDetails(
    val groupName: String,
    val count: Int,
    val items: List<List<PurchasedItem>>,
    val discount: String = "0.0",
    val transactions: List<String>,
)
