class ChristmasTree(var color: String) {

    // create function putTreeTopper()
    fun putTreeTopper(color: String) {
        val top = TreeTopper(color)
        top.sparkle()
    }

    inner class TreeTopper(var color: String) {
        // create function sparkle()
        fun sparkle() {
            println("The sparkling ${color} tree topper looks stunning on the ${this@ChristmasTree.color} Christmas tree!")
        }
    }
}