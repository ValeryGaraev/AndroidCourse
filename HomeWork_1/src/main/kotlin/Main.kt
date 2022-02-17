fun main() {
    val bookOne = Book(
        price = 50.0,
        wordCount = 100
    )

    val bookTwo = Book(
        price = 100.0,
        wordCount = 1500
    )

    val magazine = Magazine(price = 100.0, wordCount = 100)

    bookOne.description()
    bookTwo.description()
    magazine.description()

    bookOne == bookTwo

    val nullableBookOne: Book? = null

    val nullableBookTwo: Book? = Book(
        price = 200.0,
        wordCount = 9000
    )

    nullableBookOne?.let { buy(it) }
    nullableBookTwo?.let { buy(it) }

    val sum: (Int, Int) -> Unit = { firstNumber, secondNumber ->
        println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}\n")
    }

    sum(10, 20)

    val user = User(1, "Karen", 15, Type.FULL)
    println(user.startTime)
    Thread.sleep(1000)
    println("${user.startTime}\n")

    val users = mutableListOf(user)
    users.apply { add(User(2, "John", 18, Type.DEMO)) }
    users.apply { add(User(3, "Mark", 40, Type.FULL)) }
    users.apply { add(User(4, "Lucy", 25, Type.DEMO)) }

    val fullAccessUsers = users.filter { it.type == Type.FULL }

    val listOfUserNames = users.map { it.name }
    println(listOfUserNames.first())
    println("${listOfUserNames.last()}\n")

    doAction(Registration)
    doAction(Login(users.first()))
    doAction(Login(users.last()))
    doAction(Logout)
}