class Book(override val price: Double, override val wordCount: Int): Publication {
    override fun getType(): String = when (wordCount) {
        in 0..1000 -> "Flash Fiction"
        in 1001..7500 -> "Short Story"
        else -> "Novel"
    }

    override fun equals(other: Any?): Boolean {
        val isEqualByReference = this === other
        val isEqualByValue = other is Book && this.price == other.price && this.wordCount == other.wordCount
        println("Comparing books by reference: $isEqualByReference")
        println("Comparing books by value: $isEqualByValue\n")
        return isEqualByValue
    }
}