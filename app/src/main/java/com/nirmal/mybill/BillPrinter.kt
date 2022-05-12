package com.nirmal.mybill

import com.nirmal.mybill.domain.BillDetails
import com.nirmal.mybill.domain.PurchasedItem

class BillPrinter(private val billDetails: BillDetails) {
    private fun getPrintBlock(text: String, length: Int, rightAlign: Boolean = true): String {
        var message = ""
        if (rightAlign) {
            message += " ".repeat(length - text.length)
            message += text

        } else {

            message += text
            message += " ".repeat(length - text.length)
        }

        return message
    }

    private fun printDivider() {
        println("-".repeat(51))
    }

    private fun printSpacer() {
        println(" ".repeat(51))
    }

    private fun getPrintAmount(amount: Double): String {
        return String.format("%.2f", amount)
    }

    private fun printHeader(person: String = "") {
        printDivider()
        println(
            getPrintBlock(
                text = "Group : ${billDetails.groupName}",
                length = 20,
                rightAlign = false
            ) +
                    if (person.isNotEmpty()) " |   Person: $person" else ""
        )
        printDivider()
        println(
            getPrintBlock(
                text = "Item",
                length = 20,
                rightAlign = false,
            ) +
                    " | " +
                    getPrintBlock(
                        text = "Qty",
                        length = 10
                    ) +
                    " | " +
                    getPrintBlock(
                        text = "Amount",
                        length = 15,
                    )
        )
        printDivider()
    }

    private fun printItem(purchasedItem: PurchasedItem, price: Double) {
        println(
            getPrintBlock(
                text = purchasedItem.product.name,
                length = 20,
                rightAlign = false,
            ) +
                    " | " +
                    getPrintBlock(
                        text = purchasedItem.count.toString(),
                        length = 10
                    ) +
                    " | " +
                    getPrintBlock(
                        text = getPrintAmount(price * purchasedItem.count),
                        length = 15,
                    )
        )
    }

    private fun printSummary(
        total: Double,
        tax: Double,
        discount: Double = 0.0,
        surCharges: Double = 0.0
    ) {
        println(
            "Tax${
                getPrintBlock(
                    text = getPrintAmount(tax),
                    length = 48
                )
            }"
        )
        println(
            "Other${
                getPrintBlock(
                    text = getPrintAmount(surCharges),
                    length = 46
                )
            }"
        )
        println(
            "Discount${
                getPrintBlock(
                    text = getPrintAmount(discount),
                    length = 43
                )
            }"
        )
        println(
            "Total${
                getPrintBlock(
                    text = getPrintAmount(total),
                    length = 46
                )
            }"
        )
    }

    private fun printTransaction(paid: Double, remaining: Double = 0.0, returned: Double = 0.0) {
        if (remaining > 0) {
            println(
                "Remaining${
                    getPrintBlock(
                        text = getPrintAmount(remaining),
                        length = 42
                    )
                }"
            )
        }
        println(
            "Paid${
                getPrintBlock(
                    text = getPrintAmount(paid),
                    length = 47
                )
            }"
        )
        println(
            "Returned${
                getPrintBlock(
                    text = getPrintAmount(returned),
                    length = 43
                )
            }"
        )
    }

    fun printBill() {
        var i = 0
        var remaining = 0.0

        if (billDetails.transactions[0].startsWith("+")) {
            remaining = billDetails.transactions[0].toDouble()
            i++
        }

        when (billDetails.transactions[i]) {
            "individual" -> {
                for (billIndex in billDetails.items.indices) {
                    printHeader(person = (billIndex + 1).toString())

                    var total = 0.0
                    var totalTax = 0.0

                    for (item in billDetails.items[billIndex]) {
                        val amount = item.product.price / (1 + (item.product.tax / 100.0))
                        val tax = item.product.price - amount

                        total += (item.product.price * item.count)
                        totalTax += (tax * item.count)

                        printItem(purchasedItem = item, price = amount)
                    }

                    var discount = 0.0

                    if (billDetails.discount.endsWith("%")) {
                        discount = billDetails.discount.substring(
                            0,
                            billDetails.discount.length - 1
                        ).toDouble() * total
                        total -= discount
                    } else if (billDetails.discount.startsWith("$")) {
                        discount = billDetails.discount.substring(1).toDouble() * total
                        total -= discount
                    }

                    printDivider()

                    when (billDetails.transactions[i + 1]) {
                        "full" -> {
                            printSummary(
                                total,
                                totalTax,
                                discount,
                            )

                            printDivider()

                            printTransaction(
                                remaining = remaining,
                                paid = total - remaining,
                            )
                        }
                        "credit" -> {
                            val surCharges = 1.25 / 100.0 * total
                            total += surCharges

                            printSummary(
                                total,
                                totalTax,
                                discount,
                                surCharges = surCharges
                            )

                            printDivider()

                            printTransaction(
                                remaining = remaining,
                                paid = total - remaining,
                            )
                        }
                        else -> {
                            printSummary(
                                total,
                                totalTax,
                                discount,
                            )

                            printDivider()

                            val paid = billDetails.transactions[i + 1].toDouble()
                            val returned = paid - total - remaining

                            printTransaction(
                                remaining = remaining,
                                paid = paid,
                                returned = returned,
                            )
                        }
                    }

                    printDivider()
                }
            }
        }
    }


}