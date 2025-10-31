// Implement the six required functions here
import java.io.File 

import java.io.IOException //this is for catching error to not make it generic
import kotlin.system.exitProcess //to exit code
//so i can read from the file and store it into a data structure

const val WORD_LENGTH = 5

fun isValid(word: String): Boolean {
return word.length == WORD_LENGTH //uses truthy falsy of kotlin
}

fun readWordList(filename: String): MutableList<String>{
    
    var words = try {
        File(filename)// (file has to be called words.txt)
        .readLines() //reads even with spaces betrwwen words
        .map {it.trim()} //removes the spaces and puts it in a list<String>
        

    } catch (e: IOException){
        println("error when reading file: ${e.message}") 
        //error catching in case it doesnt work
        kotlin.system.exitProcess(0)
    }
    return words.toMutableList()
}


fun pickRandomWord(words: MutableList<String>): String{

if (words.isNotEmpty()) {
    val chosenWord = words.random() 
    //pick the random word from the list words and retyrb it
        words.remove(chosenWord)    
        return chosenWord
    } else {
        println("ERROR: did not found word with 5 letters") 
        //in case there are no 5 letter words in the fiule
        kotlin.system.exitProcess(0)
    }
}

fun obtainGuess(attempt: Int): String{
while (true) {
    println("\nGuess #$attempt: ")
    var guess = readln().uppercase() //takes in input from user
    if (isValid(guess)){
            return guess
    }
    else{println("wrong sized words, not 5. please retry\n")
    }
}
}

fun evaluateGuess(guess: String, target: String): List<Int>{
val wordLength = target.length
val solution = MutableList(wordLength){0}
for (i in 0 until wordLength){
    val guessIndex = guess[i] //the letter in the ith place in guess   
    val solutionIndex = target[i] //letter of the ith place in original word
    if (guessIndex == solutionIndex){
            solution[i] = 1 //comparison between those letters in a for loop
        // if there is a match it makes value = 1 then prints the letters in display function
    }
}
return solution
}


fun displayGuess(guess: String, matches: List<Int>){

for (i in guess.indices){
    if (matches[i]==1){ // to print out the actual letters for matches
        println(guess[i])
    }

    else {
        println("#") // printing out errors
    }
}

}


