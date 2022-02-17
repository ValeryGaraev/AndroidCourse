import java.util.Date

enum class Type {
    DEMO, FULL
}

data class User(val id: Int, val name: String, val age: Int, val type: Type) {
    val startTime: Date by lazy { Date() }
}

fun User.checkAge() {
    if (this.age >= 18) println("User is 18 or older") else throw Exception("User is under 18")
}