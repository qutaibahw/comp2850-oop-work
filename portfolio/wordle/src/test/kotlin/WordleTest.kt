import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // Write your tests here



//TESTS FOR ISVALID
    "isValid should return a true"{
        isValid("HONDA") shouldBe true
    }
    "isValid should return a false"{
        isValid("CAR") shouldBe false
    }
    "isValid should return a false"{
        isValid("LAMBORGHINI") shouldBe false
    }
    "isValid should return a false"{
        isValid("") shouldBe false
    }


//TESTS FOR EVALUATE GUESS

    "evaluateGuess should return a list of 1's"{
        evaluateGuess("HONDA","HONDA") shouldBe listOf(1,1,1,1,1)
    }

    "evaluateGuess should return a list of 0's"{
        evaluateGuess("XXXXX","HONDA") shouldBe listOf(0,0,0,0,0)
    }


    "evaluateGuess should return a list of 0's with 1 as first and last values"{
        evaluateGuess("HNDOA","HONDA") shouldBe listOf(1,0,0,0,1)
    }

    "evaluateGuess should return a list of 1's with 0 as first and last values"{
        evaluateGuess("AONDH","HONDA") shouldBe listOf(0,1,1,1,0)
    }



//TESTS FOR EVALUATE GUESS

val words = mutableListOf("HONDA", "CRATE")
val chosen = pickRandomWord(words)
words.contains(chosen) shouldBe false // word removed
chosen in listOf("HONDA", "CRATE") shouldBe true











})
