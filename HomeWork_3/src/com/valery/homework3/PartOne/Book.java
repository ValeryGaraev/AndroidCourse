package com.valery.homework3.PartOne;

public class Book implements Publication {
    private final double price;
    private final int wordsCount;

    public Book(double price, int wordsCount) {
        this.price = price;
        this.wordsCount = wordsCount;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getType() {
        if (wordsCount > 7500) {
            return "Novel";
        } else if (wordsCount > 1000) {
            return "Short Story";
        } else {
            return "Flash Fiction";
        }
    }

    @Override
    public int getWordsCount() {
        return wordsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Double.compare(book.price, price) == 0 && wordsCount == book.wordsCount;
    }
}
