import scala.io.Source
import scala.collection.mutable.ListBuffer

val filename = "1/input.txt"
val fileIterator = Source.fromFile(filename).getLines()
val blankLineRegex = """^\s*$""".r

def notMatchesBlankLine(x:String) = {
    if (blankLineRegex matches x) {
        false
    }
    else {
        true
    }
}

def groupIterator(xs:Iterator[String]) = new Iterator[List[String]] { 
    def hasNext = xs.hasNext; 
    def next = xs.takeWhile(notMatchesBlankLine(_)).toList
}

var lol = new ListBuffer[List[Int]]()

for (list <- groupIterator(fileIterator)) {
    val ints = list.map(_.toInt)
    lol += ints
}

val finalList = lol.toList

val max = finalList.map(_.sum).max
