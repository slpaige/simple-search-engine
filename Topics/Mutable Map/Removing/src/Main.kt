fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    return currentMap.filter { (k, v) -> v != value }.toMutableMap()
}