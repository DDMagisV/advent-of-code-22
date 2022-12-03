import scala.io.Source

val filename = "3/input.txt"
val fileIterator = Source.fromFile(filename).getLines()


// Ascii lowercase alphabet is from 97 to 122. uppercase alphabet is from 65 to 90.
// Lowercase item types a through z have priorities 1 through 26.
// Uppercase item types A through Z have priorities 27 through 52.

def convertToNum(c: Char): Int = {
    val ascii = c.toInt
    if (ascii <= 90) { // uppercase 
        ascii - 38
    }
    else { // lowercase 
        ascii-96
    }
}

def findMatch(backpacks: Seq[String]): Char = {
    
    val intersect = backpacks(0).toList intersect backpacks(1).toList intersect backpacks(2).toList
    intersect(0)
}

def getPriority(backpacks: Seq[String]): Int = {
    val c = findMatch(backpacks)
    convertToNum(c)
}


fileIterator.grouped(3).map(x => getPriority(x)).sum



