fun main() {

var filename= "words.txt"
var words = readWordList(filename)
val chosen_word = pickRandomWord(words)

    val attempts = 5
    var current_attempts = 0

    while (current_attempts < attempts) {
        val guess_input = obtainGuess(current_attempts + 1)
        val matches = evaluateGuess(guess_input, chosen_word)
        displayGuess(guess_input, matches)


    if (guess_input == chosen_word) {
        println("correct the word was indeed $chosen_word \n")
        break
    }

    current_attempts++
    if (current_attempts == attempts) {
        println("Game Over: the word was actually $chosen_word\n")
    }
}
}
