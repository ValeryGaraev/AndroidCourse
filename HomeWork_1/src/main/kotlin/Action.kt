sealed class Action

object Registration : Action()
class Login(val user: User) : Action()
object Logout : Action()

fun doAction(action: Action) = when(action) {
    is Login -> {
        println("Login has started\n")
        auth(action.user, ::updateCache)
    }
    is Logout -> println("Logout has started\n")
    is Registration -> println("Registration has started\n")
}

inline fun auth(user: User, completion: () -> Unit) = try {
    user.checkAge()
    authCallback.authSuccess()
    completion()
} catch (ex: Exception) {
    println(ex.message)
    authCallback.authFailed()
}

fun updateCache() {
    println("Cache has been updated\n")
}