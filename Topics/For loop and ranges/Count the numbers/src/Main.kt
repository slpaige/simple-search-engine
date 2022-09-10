fun main() {
    // put your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val n = readln().toInt()

    var numCount = 0

    for (i in a..b) {
        if (i % n == 0) {
            numCount++
        }
    }

    println(numCount)
}