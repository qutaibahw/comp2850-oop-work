import java.io.File //so i can read from the file and store it into a data structure

fun isValid(word: String): Boolean {
return word.length == 5 //uses truthy falsy of kotlin
}

fun readWordList(filename: String): MutableList<String>{
    var words = try {
        File(filename).readText()//reads whole thing as one string (file has to be called words.txt)
        .split(",")//removes the commas
        .map {it.trim()} //removes the spaces and puts it in a list<String>
        .filter { it.length == 5 } //makes words only 5 letters

    } catch (e: Exception){
        println("error when reading file: ${e.message}") //error catching in case it doesnt work
        kotlin.system.exitProcess(0)
    }
    return words.toMutableList()
}


fun pickRandomWord(words: MutableList<String>): String{

if (words.isNotEmpty()) {
    val chosen_word = words.random() //pick the random word from the list words and retyrb it
        words.remove(chosen_word)    
        return chosen_word
    } else {
        println("ERROR: did not found word with 5 letters") //in case there are no 5 letter words in the fiule
        kotlin.system.exitProcess(0)
    }
}

fun obtainGuess(attempt: Int): String{
while (true) {
    println("\nGuess #$attempt: ")
    var guess = readln().uppercase() //takes in input from user
    if (isValid(guess)){//makes sure its actuyally 5 letters long
            return guess
    }
    else{println("wrong sized words, not 5. please retry\n")
    }
}
}

fun evaluateGuess(guess: String, target: String): List<Int>{
val solution = MutableList(5){0}
for (i in 0 until 5){
    val g = guess[i] //the letter in the ith place in guess   
    val c = target[i] //letter of the ith place in original word
    if (c==g){
        solution[i] = 1
    }
}
return solution
}


fun displayGuess(guess: String, matches: List<Int>){

for (i in guess.indices){
    if (matches[i]==1){
        println(guess[i])
    }

    else {
        println("#")
    }
}

}


