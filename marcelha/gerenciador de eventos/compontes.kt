fun readInt(message: String, errorMessage: String, range: IntRange = 0..Int.MAX_VALUE): Int {
    while (true) {
        print(message)
        val input = readlnOrNull()?.toIntOrNull()
        if (input != null && input in range) return input
        println(errorMessage)
    }
}

fun readString(message: String, errorMessage: String, minLength: Int = 0): String {
    while (true) {
        print(message)
        val input = readlnOrNull() ?: ""
        if (input.length >= minLength) return input
        println(errorMessage)
    }
}

fun printTable(header: String, items: List<Any>) {
    println("\n=== $header ===")
    if (items.isEmpty()) println("Lista vazia.")
    else items.forEach { println(it) }
    println("==============================")
}
