interface Publication {
    val price: Double
    val wordCount: Int
    fun getType(): String
}

fun Publication.description() {
    println("This publication's type is ${getType()}")
    println("This publication has $wordCount words")
    println("This publication costs €$price\n")
}

fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was €${publication.price}\n")
}