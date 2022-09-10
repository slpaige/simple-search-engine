fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int {
    return { number -> g ( h ( number ) ) }
}