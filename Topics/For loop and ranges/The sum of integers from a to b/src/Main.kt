fun main() {
    // put your code here
    val int1 = readln().toInt()
    val int2 = readln().toInt()

    var sum = 0
    for (i in int1..int2) {
        sum += i
    }

    println(sum)
}