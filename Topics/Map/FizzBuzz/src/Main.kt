const val FIVE = 5
const val THREE = 3

fun iterator(map: Map<String, Int>) {
    // put your code here
    for ((key, value) in map) {
        if (value % THREE == 0) {
            println("Fizz")
        } else if (value % FIVE == 0) {
            println("Buzz")
        } else {
            println("FizzBuzz")
        }
    }
}