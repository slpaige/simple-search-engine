import java.io.FileInputStream

// write your code here

fun main(args: Array<String>) {
  // put your code here
    val list1 = arrayOf(8,19,12,7,6,5)
    val list2 = arrayOf(19,6,5)
    var steps = 0

    for (i in list1) {
        for (j in list2) {
            steps++
            if(i == j) {
               break
            }
        }
    }

    println(steps)
}
