class Magazine(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType() = "Magazine"
}