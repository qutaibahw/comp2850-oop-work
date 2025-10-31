import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File

@Suppress("unused")
class WordleTest : StringSpec(
    {
    // Write your tests here

//TESTS FOR READING FILE


// TESTS FOR ISVALID
    "isValid should return a true" {
        isValid("HONDA") shouldBe true
    }
    "isValid should return a false" {
        isValid("CAR") shouldBe false
    }
    "isValid should return a false" {
        isValid("LAMBORGHINI") shouldBe false
    }
    "isValid should return a false" {
        isValid("") shouldBe false
    }
// TESTS FOR EVALUATE GUESS

    "evaluateGuess should return a list of 1's" {
        evaluateGuess("HONDA", "HONDA") shouldBe listOf(1, 1, 1, 1, 1)
    }

    "evaluateGuess should return a list of 0's"{
        evaluateGuess("XXXXX", "HONDA") shouldBe listOf(0, 0, 0, 0, 0)
    }


    "evaluateGuess should return a list of 0's with 1 as first and last values" {
        evaluateGuess("HNDOA", "HONDA") shouldBe listOf(1, 0, 0, 0, 1)
    }

    "evaluateGuess should return a list of 1's with 0 as first and last values" {
        evaluateGuess("AONDH", "HONDA") shouldBe listOf(0, 1, 1, 1, 0)
    }

// TESTS FOR EVALUATE GUESS
"pickRandomWord must remove a word from list and return valid word" {
val words = mutableListOf("HONDA", "CRATE")
val chosen = pickRandomWord(words)
words.contains(chosen) shouldBe false   //teh word should be removed 1
(chosen in listOf("HONDA", "CRATE")) shouldBe true 
}

"readWordList should correctly read and parse words" {
    val testFile = File("new_words.txt")
    testFile.writeText("honda,engine,crate") //made a new file and added those words size =  3

    val expected = listOf("honda", "engine", "crate") //this is expected output
  
    val words = readWordList("test_words.txt") //running the actual function

    words.size shouldBe expected.size //checks the size and the words
    words shouldBe expected
    testFile.delete() //cleans up in the end the filesso no temp files remain in directory

}
        }
                )
