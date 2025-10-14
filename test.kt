fun main(){
    



    //kotlin has mutable and immutable types of all data collection: mutable as in you can change it
    

    
    val numbers_integers = Array<String>(5) {"hey"} //done with initialization, which is why we didnt use val numbers: Array<Int> = arrayOf(....)
    //array is a list, but with fixed size (5)
    //this uses the lambda {} function, it will make all elements in there have "hey", with 5 elements cuz of the () all being strings. 
    //you can use lambda for putting an equation

    //arrays using the arrayOf() function. you have to use the same type of variable in there, unless you do Array<Any>
    val numbers_integers_arr = arrayOf(1,2,3)
    val numbers_integers_arr_any: Array<Any> = arrayOf(1,2,3,"hi") //to mix data types use Any


    //when arrays are printed they give off very low level type outputs




    //list: you can specify tyhe type of data thats gonna be inside the list
    //list is ordered, can have duplicates, find stuff via index
    val cars = listOf("lambo", "bmnw", "ferrari")
    


    //mutable version, you gotta include mutable then listOf
    val carsm = mutableListOf("lambo", "bmnw", "ferrari")
    val cars_toimmutable = cars.toMutableList()
    
    
    println("arrays: \n" + numbers_integers)
    println(numbers_integers_arr)
    println(numbers_integers_arr_any)
    println("\nLists: "+ cars)

    println("before: "+carsm)
    carsm.add("amg")
    println("after: " + carsm)
    cars_toimmutable.add("mclaren")
    println(cars_toimmutable)

}