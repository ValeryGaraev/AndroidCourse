interface AuthCallback {
    fun authSuccess()
    fun authFailed()
}

val authCallback = object : AuthCallback {
    override fun authSuccess() {
        println("Authorization has succeeded\n")
    }

    override fun authFailed() {
        println("Authorization has failed\n")
    }
}