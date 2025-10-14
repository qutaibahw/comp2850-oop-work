// Task 3.1: command line arguments
fun main(argument: Array<String>) {
    
    
    val apple = readln().toInt()
    when (apple){
        1 -> println("you put 1")
        2 -> println("you put 2")
        else -> println("else")
    } 

    println("Enter your name: ")
    val name = readln()
    println("\nage: ")
    val age = readln().toInt()

    sayhi(name, age)
}



fun sayhi(name_of_person: String, age_of_person: Int){
    var greeting = setOf("hey", "hi", "gday", "wsg")
    
    println("${greeting.random()} ${name_of_person}, happy birthday ! youre officially $age_of_person")
}

























