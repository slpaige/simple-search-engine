fun makeMyWishList(wishList: Map<String, Int>, limit: Int): MutableMap<String, Int> {
    val realisticWishes = mutableMapOf<String, Int>()

    for ((k, v) in wishList) {
        if (v <= limit) {
            realisticWishes[k] = v
        }
    }

    return realisticWishes
}