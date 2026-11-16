package org.example

// Задача 2. Согласование слова «человек» с числом лайков.
// Форма «человеку» нужна, если число оканчивается на 1, но не на 11 (11, 111, 211 ...).
// Во всех остальных случаях — «людям».

fun likesEnding(likes: Int): String {
    // остаток на 10 — последняя цифра числа, остаток на 100 — две последние
    return if (likes % 10 == 1 && likes % 100 != 11) {
        "человеку"
    } else {
        "людям"
    }
}

fun likesMessage(likes: Int): String = "Понравилось $likes ${likesEnding(likes)}"

fun task2() {
    // число лайков
    val likes = 41

    println(likesMessage(likes))

    println()
    println("Другие значения:")
    for (value in listOf(1, 2, 5, 11, 21, 32, 41, 100, 101, 111, 1001)) {
        println("  " + likesMessage(value))
    }
}

fun main() {
    task2()
}
