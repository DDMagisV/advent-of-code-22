import scala.io.Source

val filename = "3/input.txt"
val fileIterator = Source.fromFile(filename).getLines()

def convertToNum(c: Char): Int = {
    val ascii = c.toInt
    if (ascii <= 90) { // uppercase 
        ascii - 38
    }
    else { // lowercase 
        ascii-96
    }
}

def findMatch(str: String): Char = {
    val length = str.length
    val compartmentOne = str.substring(0, length/2)
    val compartmentTwo = str.substring(length/2, length)
    val intersect = compartmentOne.toList intersect compartmentTwo.toList
    intersect(0)
}

def getPriority(str: String): Int = {
    val c = findMatch(str)
    convertToNum(c)
}


fileIterator.map(x => getPriority(x)).sum


// lowercase alphabet is from 97 to 122. uppercase alphabet is from 65 to 90.
// 
// Lowercase item types a through z have priorities 1 through 26.
// Uppercase item types A through Z have priorities 27 through 52.
