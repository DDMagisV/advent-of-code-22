import scala.io.Source

val filename = "2/input.txt"
val fileIterator = Source.fromFile(filename).getLines()

def getScoreOfPlayed(my: Char): Int = {
    my match {
        case 'X' => 1
        case 'Y' => 2
        case 'Z' => 3
    }
}

def hasWon(opp: Char, my: Char): Int = {
    (opp, my) match {
        case ('A', 'X') => 3
        case ('B', 'Y') => 3
        case ('C', 'Z') => 3

        case ('A', 'Z') => 0
        case ('B', 'X') => 0
        case ('C', 'Y') => 0

        case ('A', 'Y') => 6
        case ('B', 'Z') => 6
        case ('C', 'X') => 6
    }
}

// loose: X, draw: Y, win: Z
// Opp: A for Rock, B for Paper, and C scissors
// My: X Rock, Y Paper, Z Scissors 
def whatINeedToPlay(opp: Char, outcome: Char): Char = {
    (opp, outcome) match {
        case ('A', 'X') => 'Z'
        case ('A', 'Y') => 'X'
        case ('A', 'Z') => 'Y'

        case ('B', 'X') => 'X'
        case ('B', 'Y') => 'Y'
        case ('B', 'Z') => 'Z'

        case ('C', 'X') => 'Y'
        case ('C', 'Y') => 'Z'
        case ('C', 'Z') => 'X'
    }
}

def getScore(x: String): Int = {
    var score = 0
    val opp = x.charAt(0)
    val my = whatINeedToPlay(opp, x.charAt(2))
    score += getScoreOfPlayed(my)
    score += hasWon(opp, my)
    score
}


val list = fileIterator.map(x => {
    getScore(x)
}).sum

/*
Opp: A for Rock, B for Paper, and C
My: X Rock, Y Paper, Z Scissors 

loose: 0, draw: 3, win: 6
*/
