object Math {
    //TODO
    fun abs(value: Int): Int {
        if (value < 0) {
            return value * -1
        }
        return value
    }

    fun abs(value: Double): Double {
        if (value < 0.0) {
            return value * -1.0
        }
        return value
    }
}