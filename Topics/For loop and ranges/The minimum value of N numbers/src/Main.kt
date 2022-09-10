fun main() {
    // write your code here
    val nCount = readln().toInt()
    var min = Int.MAX_VALUE

    repeat(nCount) {
        val input = readln().toInt()
        if (input < min) {
            min = input
        }
    }

    println(min)
}