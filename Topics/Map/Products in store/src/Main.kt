fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var runningTotal = 0

    for (item in shoppingList) {
        runningTotal += priceList[item] ?: 0
    }

    return runningTotal
}