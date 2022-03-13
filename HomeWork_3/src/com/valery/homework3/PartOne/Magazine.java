package com.valery.homework3.PartOne;

public class Magazine implements Publication {
    private final double price;
    private final int wordsCount;

    public Magazine(double price, int wordsCount) {
        this.price = price;
        this.wordsCount = wordsCount;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public int getWordsCount() {
        return wordsCount;
    }
}
