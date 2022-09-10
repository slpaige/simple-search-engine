package search

import java.io.File

class SearchData() {

    //this holds the entire string of text from each line in file
    private var searchRows = mutableListOf<String>()

    //capture each word in the line of text from file and which index it was part of
    private var invertedIndex = mutableMapOf<String, MutableList<Int>>()

    fun dataEntry(filePath: String) {
        for (line in File(filePath).readLines().withIndex()) {
            searchRows.add(line.value)

            for (lineSplit in line.value.split(" ")) {
                //if it exists, simply add the index if it's unique
                var invertedMutableList = invertedIndex[lineSplit.lowercase()] ?: mutableListOf<Int>()

                //no need to add same index more than 1 time
                if (!invertedMutableList.contains(line.index)) {
                    invertedMutableList.add(line.index)
                }
                invertedIndex[lineSplit.lowercase()] = invertedMutableList
            }
        }
    }

    fun searchEntries() {

        println("Select a matching strategy: ALL, ANY, NONE")
        var matchStragey = readln()
        when (matchStragey) {
            "ALL" -> searchAll()
            "ANY" -> searchAny()
            "NONE" -> searchNone()
            else -> {
                println("Invalid strategy!")
                return
            }
        }

    }

    private fun searchAll() {
        var intersected = mutableSetOf<Int>()

        println("Enter a name or email to search all matching people.")
        var searchInput = readln().lowercase().split(" ")
        var foundLines = mutableSetOf<String>()

        println()

        //find index for given word
        for (word in searchInput.withIndex()) {
            if (invertedIndex.keys.contains(word.value)) {
                val tempIndex = invertedIndex[word.value.lowercase()]?.toMutableSet() ?: mutableSetOf()
                if(word.index == 0) {
                    intersected = tempIndex
                } else {
                    intersected = intersected.intersect(tempIndex).toMutableSet()
                }
            }
        }

        for (allIndex in intersected) {
            foundLines.add(searchRows[allIndex])
        }

        printResults(foundLines)
    }



    private fun searchAny() {

        println("Enter a name or email to search all matching people.")
        var searchInput = readln().lowercase().split(" ")
        var foundLines = mutableSetOf<String>()

        println()

        //find index for given word
        for (word in searchInput) {
            val wordIndexes = invertedIndex[word.lowercase()] ?: mutableListOf()


            if (wordIndexes.any()) {
                for (index in wordIndexes) {
                    foundLines.add(searchRows[index])
                }
            }
        }

        printResults(foundLines)
    }


    private fun searchNone() {
        println("Enter a name or email to search all matching people.")
        var searchInput = readln().lowercase().split(" ")
        var foundLines = mutableSetOf<String>()

        var wordIndexes = mutableListOf<Int>()

        println()

        //find index for given word
        for (word in searchInput) {
            if (invertedIndex.keys.contains(word)) {
                wordIndexes.addAll(invertedIndex[word.lowercase()]!!)
            }
        }

        for (row in searchRows.withIndex()) {
            if(wordIndexes.contains(row.index)) {
                continue
            } else {
                foundLines.add(row.value)
            }
        }
        printResults(foundLines)
    }

    fun printAllPeople() {
        println("=== List of people ===")
        for (string in searchRows) {
            println(string)
        }
        println()
    }

    private fun printResults(foundLines: MutableSet<String>) {

        if (foundLines.any()) {
            var personOrPersons = "person"
            if (foundLines.size > 1) {
                personOrPersons = "persons"
            }
            println("${foundLines.size} $personOrPersons found:")
            for (foundLine in foundLines) {
                println(foundLine)
            }
        } else {
            println("No matching people found.")
        }
        println()
    }
}

fun main(args: Array<String>) {
    var search = SearchData();
    search.dataEntry(args[1])

    while (true) {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
        val entry = readln()

        println()
        when (entry) {
            "1" -> search.searchEntries()
            "2" -> search.printAllPeople()
            "0" -> {
                println("Bye!")
                break;
            }
            else -> {
                println("Incorrect option! Try again.")
                println()
            }
        }
    }
}

