
const val MAX_ATTEMPTS = 10
fun main() {

var filename = "/workspaces/comp2850-oop-work/portfolio/wordle/data/words.txt"
var words = readWordList(filename)
val chosenWord = pickRandomWord(words)

    var currentAttempts = 0

    while (currentAttempts < MAX_ATTEMPTS) {
        val guessInput = obtainGuess(currentAttempts + 1)
        val matches = evaluateGuess(guessInput, chosenWord)
        displayGuess(guessInput, matches)


    if (guessInput == chosenWord) {
        println("correct the word was indeed $chosenWord \n")
        break
    }

    currentAttempts++
    if (currentAttempts == MAX_ATTEMPTS) {
        println("Game Over: the word was actually $chosenWord\n")
    }
}
}
