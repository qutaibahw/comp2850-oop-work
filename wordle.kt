import java.io.File //so i can read from the file and store it into a data structure

fun choose_word(): String {

println("\nEnter number of letters: ")    

val num_of_letters = try {
        readln().toInt()
    } catch (e: NumberFormatException) {
        println("not integer\n")
        return choose_word()
    }
//take in an integer


var words = try {
        File("words.txt").readText()//reads whole thing as one string (file has to be called words.txt)
            .split(",")//removes the commas
            .map { it.trim() //removes the spaces and puts it in a list<String>
            }
    } catch (e: Exception) {
        println("Error reading file: ${e.message}") //error catching in case it doesnt work
        kotlin.system.exitProcess(0)
    }

var words_letters = mutableListOf<String>()
//a mutable list that contains the words with the same number of letters as inputed by user in num_of_letters

for (word in words){
    if (word.length == num_of_letters){
        words_letters.add(word)
    } //stored the words that have same num of letters in the list thru a loop
    
}
return if (words_letters.isNotEmpty()) {
        words_letters.random()
} //returns a randomized word from the list of words with n number of letters
else {
        println("not found word with $num_of_letters letters")  
        kotlin.system.exitProcess(0)
        //if not found, game will shut down
    }
}



fun guess(chosen_word: String, attempts: Int){

var current_attempts = 0 //counter for the number of attempts left
while (current_attempts < attempts) {
    println("\nattempt ${current_attempts + 1}/$attempts\nMake your guess: ")
    val guess_input = readln().lowercase() 
    if (guess_input.length == chosen_word.length){
        if (guess_input == chosen_word){
            println("Congrats, thats correct ! the word was indeed $chosen_word")
            break //make sure a word of same length is chosen, otherwise its useless
        }
        else{
        for (i in 0 until chosen_word.length){
            val g = guess_input[i] //the letter in the ith place in guess   
            val c = chosen_word[i] //letter of the ith place in original word
            if (c==g){
                println("exact match for letters ${g} at position ${i+1}") //exact match at position and word
            }
            else if (chosen_word.contains(g)){ //no match at position, but the letters are in both 
                println("semi match for the letter ${g}. its correct, but in the wrong position (NOT in position ${i+1})")
            }
            else{
            println("the letter ${g} is WRONG ... placed in position ${i+1}")
            } //no position or letter similarity
        }
    }
    }
    else{
        println("Wrong sized words, not ${chosen_word.length}. please retry\n")
    }
    current_attempts++
        if (current_attempts == attempts) {
            println("\nOut of attempts! The word was: $chosen_word")
        } //counter for attempts. resetter 
    }
}

fun main(){
val chosen_word = choose_word()
//println("FOR ADMIN USE: $chosen_word")

var attempts: Int
while (true) {
        println("How many attempts do you want: ")
        val input = readln()
        try {
            attempts = input.toInt()
            break
        } 
        catch (e: NumberFormatException) {
            println("not integer\n")
        } //resetter in case input isnt an integer
}
guess(chosen_word, attempts) //fires up the function guess
}