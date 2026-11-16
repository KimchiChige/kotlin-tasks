package org.example

import kotlin.math.roundToInt

// Задача 3. Скидки на музыку.
//   от 0 до 1 000 руб.      — скидки нет;
//   от 1 001 до 10 000 руб. — скидка 100 рублей;
//   от 10 001 руб. и выше   — скидка 5 % от суммы.
// Постоянному покупателю (Boolean) после обычной скидки дают ещё 1 %.

fun calculatePrice(amount: Int, isRegularCustomer: Boolean): Int {
    var price = amount

    if (price in 1_001..10_000) {
        // скидка 100 рублей
        price = price - 100
    } else if (price > 10_000) {
        // скидка 5 % от суммы — значит, платим 95 % стоимости
        // roundToInt() округляет до целых рублей: 14107.5 -> 14108
        price = (price * 0.95).roundToInt()
    }

    // дополнительная скидка постоянного покупателя — ещё 1 %
    if (isRegularCustomer) {
        price = (price * 0.99).roundToInt()
    }

    return price
}

fun task3() {
    // сумма покупки в рублях
    val amount = 15_000
    // постоянный покупатель или нет
    val isRegularCustomer = true

    val status = if (isRegularCustomer) "да" else "нет"

    println("Сумма покупки: $amount руб.")
    println("Постоянный покупатель: $status")
    println("Итоговая стоимость: ${calculatePrice(amount, isRegularCustomer)} руб.")
    println("(обычный покупатель заплатил бы: ${calculatePrice(amount, false)} руб.)")

    println()
    println("Другие покупки:")
    for (value in listOf(0, 1_000, 1_001, 10_000, 10_001, 20_000)) {
        val usualPrice = calculatePrice(value, false)
        val regularPrice = calculatePrice(value, true)
        println("  $value руб. -> обычный: $usualPrice руб., постоянный: $regularPrice руб.")
    }
}

fun main() {
    task3()
}
