fun sayhi(inputs_from_user: String): String { //return type shown after the : outside of the sayhi()
    val words = setOf("nice to meet you", "good to meet you", "great to see you").random()
    return "$words $inputs_from_user"
}